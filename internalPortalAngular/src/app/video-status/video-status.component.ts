import { Component, OnInit } from '@angular/core';
import { VideoDetailsService } from '../video-details.service';
import { DBFile } from '../Models/dbfile';
import { Router } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';
import { VideoDTO } from '../Models/VideoDTO';
import { ReportService } from '../service/report.service';
@Component({
  selector: 'app-video-status',
  templateUrl: './video-status.component.html',
  styleUrls: ['./video-status.component.scss']
})
export class VideoStatusComponent implements OnInit {

  constructor(private VideoService : VideoDetailsService) { }

  video: Array<DBFile> = [];
  ngOnInit(): void {

    this.VideoService.getPending().subscribe(resp => {
      console.log(resp);
      this.video = resp;
    })

    
  }

  onApprove(id:Number)
  {
    console.log(id);
    //  this.VideoService.approveVideo(id).subscribe(resp => {
    //   console.log(resp);
    //   this.video = resp;
    // })
  }
  onReject(id:Number){
    console.log(id);
    // this.VideoService.rejectVideo(id).subscribe(resp => {
    //   console.log(resp);
    //   this.video = resp;
    // })
  }
  displayedColumns: String[] = ['id', 'title','description', 'category', 'uploadBy', 'uploadTime', 'play', 'status'];
  dataSource = this.video;

  
}
