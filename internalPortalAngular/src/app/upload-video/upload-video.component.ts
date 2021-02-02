import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { DBFile } from '../Models/dbfile';
import { VideoDetailsService } from '../video-details.service';

@Component({
  selector: 'app-upload-video',
  templateUrl: './upload-video.component.html',
  styleUrls: ['./upload-video.component.scss']
})
export class UploadVideoComponent implements OnInit {
  dbfile:DBFile=new DBFile();
  message: String='';
  files: File;
  // id:Number;
  constructor(private service:VideoDetailsService,private httpClient: HttpClient) { }

  ngOnInit(): void {
  }

  onFileChanged(event){
    this.files = event.target.files[0];
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
          this.message = 'Image uploaded successfully';
        } else {
          this.dbfile.id=null;
          this.message = 'Image not uploaded successfully';
        }
      }
      );
  }

  onSaveData(){
    this.service.upLoadDataFromRemote(this.dbfile).subscribe(resp=>{
      this.message="Data Successfully Uploaded";
    },
    error=>{
      this.message="Error uploading data";
    });
  }

}