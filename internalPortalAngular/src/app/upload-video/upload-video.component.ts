import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { DBFile } from '../Models/dbfile';
import { VideoDetailsService } from '../service/video-details.service';
import { FormBuilder, Validators } from '@angular/forms';
import { Category } from '../Models/category';
import { RegistrationService } from '../service/registration.service';

@Component({
  selector: 'app-upload-video',
  templateUrl: './upload-video.component.html',
  styleUrls: ['./upload-video.component.scss']
})
export class UploadVideoComponent implements OnInit {
  categories:Array<Category>=[];
  category:Category=new Category();
  category_id:Number;
  dbfile:DBFile=new DBFile();
  message: String='';
  instruction: String='';
  files: File;
  selectedValue:String;
  formDoc: any;
  fileAttr = 'Choose File';
  flag:Boolean=false;
  isVisible:Boolean=true;
  
  constructor(private service:VideoDetailsService,private httpClient: HttpClient, private _fb: FormBuilder,private RegService : RegistrationService) { }

  ngOnInit(): void {
    this.service.getAllCategory().subscribe(categories=>{
      this.categories=categories;
      console.log(categories);
    });
    this.formDoc = this._fb.group({
      requiredfile: [
        undefined,
        [Validators.required]
      ]
    });
  }

  onFileChanged(event){
    this.files = event.target.files[0];
    this.fileAttr=this.files.name;
    console.log(this.files.name);
    console.log(this.files);
    this.instruction='Click upload button to upload the video.';
  }

  oonUpload(){
    const uploadImageData = new FormData();
    uploadImageData.append('file', this.files, this.files.name);
    this.httpClient.post('http://localhost:8080/video/uploadFile', uploadImageData, { observe: 'response' })
      .subscribe((response) => {
        console.log(response);
        if (response.status === 200) {
          const body:any=response.body;
          this.dbfile.id=body.id;
          this.message = 'Video uploaded successfully now press the save button.';
        } else {
          this.dbfile.id=null;
          this.message = 'Video not uploaded successfully';
        }
      }
      );
      this.flag=true;
      this.isVisible=false;
      this.instruction='Click the save button to save the video details.'
      alert('Click the save button now to upload the data.');}

  onSaveData(){
    this.categories.forEach(category=>{
      if(category.id===this.category_id){
        this.dbfile.category=category;
      }
    });
    this.dbfile.creator = JSON.parse(this.RegService.getUser());
    console.log(this.dbfile);
    this.service.upLoadDataFromRemote(this.dbfile).subscribe(resp=>{
      this.message="Data Successfully Uploaded";
    },
    error=>{
      this.message="Error uploading data";
    });
    window.location.reload();
  }

}