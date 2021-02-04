import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Category } from '../Models/category';
import { DBFile } from '../Models/dbfile';
import { VideoDetailsService } from '../video-details.service';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-upload-video',
  templateUrl: './upload-video.component.html',
  styleUrls: ['./upload-video.component.scss']
})
export class UploadVideoComponent implements OnInit {
  categories:Array<Category>=[];
  category:Category=new Category();
  // category:Array<String>=[];
  category_id:Number;
  dbfile:DBFile=new DBFile();
  message: String='';
  files: File;
  selectedValue:String;
  formDoc: any;
  fileAttr = 'Choose File';
  // id:Number;
  constructor(private service:VideoDetailsService,private httpClient: HttpClient,private _fb: FormBuilder) { }

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
  }

  onUpload(){
    // this.service.upLoadFromRemote(this.files).subscribe(resp=>{
    //   this.message="Video Successfully Uploaded";
    // },
    // error=>{
    //   this.message="Error uploading video";
    // })
    const uploadImageData = new FormData();
    uploadImageData.append('file', this.files, this.files.name);
    this.httpClient.post('http://localhost:8080/video/uploadFile', uploadImageData, { observe: 'response' })
      .subscribe((response) => {
        console.log(response);
        if (response.status === 200) {
          const body:any=response.body;
          this.dbfile.id=body.id;
          this.message = 'Video uploaded successfully';
        } else {
          this.dbfile.id=null;
          this.message = 'Video not uploaded successfully';
        }
      }
      );
  }

  onSaveData(){
    this.categories.forEach(category=>{
      if(category.id===this.category_id){
        this.dbfile.category=category;
      }
    });
    this.service.upLoadDataFromRemote(this.dbfile).subscribe(resp=>{
      // console.log(this.dbfile.title);
      // console.log(this.dbfile);
      // console.log(resp);
      // // this.category
      this.message="Data Successfully Uploaded";
    },
    error=>{
      this.message="Error uploading data";
    });
  }
  
}