import { Component, OnInit } from '@angular/core';
import { DBFile } from '../Models/dbfile';
import { User } from '../Models/User';
import { RegistrationService } from '../service/registration.service';
import { SharedService } from '../service/shared.service';
import { VideoDetailsService } from '../service/video-details.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.scss']
})
export class EditComponent implements OnInit {

  dbfile: DBFile = new DBFile();
  user: User;
  video: DBFile;
  myVideos: Array<DBFile> = [];

  constructor(private videoService: VideoDetailsService, private regService: RegistrationService, private sharedService: SharedService) { }

  ngOnInit(): void {

  }

  onEdit() {
    this.video = this.sharedService.getEditVideo();

    this.video.title = this.dbfile.title;
    this.video.description = this.dbfile.description;
    console.log(this.video);
    this.videoService.EditDetails(this.video).subscribe(resp => {
      console.log(resp);
    })

    console.log(this.video);

  }

}