import { Component, OnInit } from '@angular/core';
import { VideoDetailsService } from '../service/video-details.service';
import { DBFile } from '../Models/dbfile';
import { Category } from '../Models/Category';
import { SharedService } from '../service/shared.service';
import { Router } from '@angular/router';
import { VideoDTO } from '../Models/VideoDTO';
@Component({
  selector: 'app-video-status',
  templateUrl: './video-status.component.html',
  styleUrls: ['./video-status.component.scss']
})
export class VideoStatusComponent implements OnInit {

  constructor(private router: Router, private VideoService: VideoDetailsService, private sharedService: SharedService,) { }

  video: Array<DBFile> = [];
  prev_url: any;
  ngOnInit(): void {

    this.VideoService.getPending().subscribe(resp => {
      console.log(resp);
      this.video = resp;
    })

  }

  onApprove(video: DBFile, category: Category) {
    video.status = "APPROVED";
    this.VideoService.UpdateStatus(video).subscribe(resp => {
      console.log(resp);
    })

  }

  onPlay(id: Number) {
    console.log(id);
    this.VideoService.getVideo(id).subscribe(resp => {
      const videoDTO: VideoDTO = resp as VideoDTO;
      console.log(resp);
      this.prev_url = "data:video/mp4;base64," + videoDTO.data;
      console.log("hi");

      this.sharedService.setVideoDTO(videoDTO);
      this.router.navigate(['/playVideo', id]);

    });
  }
  onReject(video: DBFile) {
    video.status = "REJECTED";
    this.VideoService.UpdateStatus(video).subscribe(resp => {
      console.log(resp);
    })

  }
  displayedColumns: String[] = ['id', 'title', 'description', 'category', 'uploadBy', 'uploadTime', 'play', 'status', 'editStatus'];
  dataSource = this.video;

}