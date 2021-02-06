import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DBFile } from '../Models/dbfile';
import { User } from '../Models/User';
import { VideoDTO } from '../Models/VideoDTO';
import { RegistrationService } from '../registration.service';
import { SharedService } from '../shared.service';
import { VideoDetailsService } from '../video-details.service';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { EditComponent } from '../edit/edit.component';

@Component({
  selector: 'app-my-videos',
  templateUrl: './my-videos.component.html',
  styleUrls: ['./my-videos.component.scss']
})
export class MyVideosComponent implements OnInit {

  title: String;
  description: String;

  video: Array<DBFile> = [];
  myVideos : Array<DBFile> = [];
  user: User;
  displayedColumns: String[] = ['id', 'title','description', 'category', 'uploadTime', 'status', 'play', 'edit','delete'];
  prev_url: any;


  constructor(private videoService: VideoDetailsService, private regService: RegistrationService, private sharedService: SharedService, private router: Router, public dialog: MatDialog) {
    this.user = JSON.parse(this.regService.getUser());
    this.videoService.getAll().subscribe(resp => {
      console.log(resp);
      this.video = resp;
      // this.myVideos = this.video;
      for(let i=0; i<this.video.length; i++){
        // console.log(this.video[i].creator.id);
        // console.log(this.user.id);
        if(this.video[i].creator.id === this.user.id){
          if(this.myVideos.length === 0){
            this.myVideos = [this.video[i]];
          }
          else{
          this.myVideos.push(this.video[i]);
          }
          // console.log("hiiiiii");
        }
      }
      console.log(this.myVideos);
    })
   }

  ngOnInit(): void {
  }

  onPlay(id: Number) {
    console.log(id);
    this.videoService.getVideo(id).subscribe(resp => {
      const videoDTO: VideoDTO = resp as VideoDTO;
      console.log(resp);
      this.prev_url = "data:video/mp4;base64," + videoDTO.data;
      console.log("hi");
      // this.sharedService.setPrevUrl(this.prev_url);
      this.sharedService.setVideoDTO(videoDTO);
      this.router.navigate(['/playVideo',id]);
      this.sharedService.setVid(id);
    });
}

openDialog(video): void {
  const dialogRef = this.dialog.open(EditComponent, {
    width: '300px',
    data: {title: this.title, description: this.description}
  });

  this.sharedService.setEditVideo(video);

  dialogRef.afterClosed().subscribe(result => {
    console.log('The dialog was closed');
    this.title = result;
  });
}

onDelete(Video_id: Number) {
  
  
  this.videoService.deleteVideo(Video_id).subscribe(resp => {
  //  const videoDTO: VideoDTO = resp as VideoDTO;
    console.log(resp);
    // this.prev_url = "data:video/mp4;base64," + videoDTO.data;
    // console.log("hi");
    this.myVideos = this.myVideos.filter(v => {return v.id!=Video_id})
    
 });

 
}

}
  
