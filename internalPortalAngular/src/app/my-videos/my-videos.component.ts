import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DBFile } from '../Models/dbfile';
import { User } from '../Models/User';
import { VideoDTO } from '../Models/VideoDTO';
import { RegistrationService } from '../service/registration.service';
import { SharedService } from '../service/shared.service';
import { VideoDetailsService } from '../service/video-details.service';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { EditComponent } from '../edit/edit.component';
import {ConfirmationDialogComponent} from '../confirmation-dialog/confirmation-dialog.component';

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
      
      for(let i=0; i<this.video.length; i++){
        
        if(this.video[i].creator.id === this.user.id){
          if(this.myVideos.length === 0){
            this.myVideos = [this.video[i]];
          }
          else{
          this.myVideos.push(this.video[i]);
          }
          
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
      
      this.sharedService.setVideoDTO(videoDTO);
      this.sharedService.setVid(id);
      this.router.navigate(['/playVideo',id]);
     
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
  
    console.log(resp);   
    this.myVideos = this.myVideos.filter(v => {return v.id!=Video_id})
    
 });

}

openConfirmationDialog(Video_id: Number): void {
  const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
    width: '300px',
  });

  dialogRef.afterClosed().subscribe(result => {
    console.log(`Dialog result: ${result}`);
    if(result){
      this.onDelete(Video_id)
    }
  });
}

}
  
