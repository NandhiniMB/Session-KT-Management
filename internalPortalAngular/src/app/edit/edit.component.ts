import { Component, OnInit } from '@angular/core';
import { DBFile } from '../Models/dbfile';
import { User } from '../Models/User';
import { RegistrationService } from '../registration.service';
import { SharedService } from '../shared.service';
import { VideoDetailsService } from '../video-details.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.scss']
})
export class EditComponent implements OnInit {

  dbfile:DBFile=new DBFile();
  user: User;
  video: DBFile;
  myVideos : Array<DBFile> = [];

  constructor(private videoService: VideoDetailsService, private regService: RegistrationService, private sharedService: SharedService) { }

  ngOnInit(): void {
    // this.videoService.getAll().subscribe(resp => {
    //   console.log(resp);
    //   this.video = resp;
    // })
  }

  onEdit(){
    this.video = this.sharedService.getEditVideo();

    this.video.title = this.dbfile.title;
    this.video.description = this.dbfile.description;
    console.log(this.video);
    this.videoService.EditDetails(this.video).subscribe(resp => {
      console.log(resp);
    })
    // video = this.dbfile.title
    console.log(this.video);

    // console.log(this.dbfile);
  }



}
