import { Component, OnInit } from '@angular/core';
import { VideoDetailsService } from '../video-details.service';
import { DBFile } from '../Models/dbfile';
import {Category} from '../Models/Category';

@Component({
  selector: 'app-video-status',
  templateUrl: './video-status.component.html',
  styleUrls: ['./video-status.component.scss']
})
export class VideoStatusComponent implements OnInit {

  constructor(private VideoService : VideoDetailsService) { }

  video: Array<DBFile> = [];
  ngOnInit(): void {

    this.VideoService.getAll().subscribe(resp => {
      console.log(resp);
      this.video = resp;
    })

    
  }

  onApprove(video:DBFile,category:Category)
  {
    video.status="APPROVED";
    video.category=new Category();
    video.category.id=1;
    this.VideoService.UpdateStatus(video).subscribe(resp => {
      console.log(resp);
    })
    // this.VideoService.sendSubscriptionMail(video,category).subscribe(resp => { //send mail done need to get  category here
    //   console.log(resp);
    // })
    
  }

  onReject(video:DBFile){
    video.status="REJECTED";
    this.VideoService.UpdateStatus(video).subscribe(resp => {
      console.log(resp);
    })
    
  }
  displayedColumns: String[] = ['id', 'title','description', 'category', 'uploadBy', 'uploadTime', 'play', 'status', 'editStatus'];
  dataSource = this.video;

  
}
