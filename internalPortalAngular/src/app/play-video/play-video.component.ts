import { Component, OnInit } from '@angular/core';
import { VideoDetailsService } from '../video-details.service';

@Component({
  selector: 'app-play-video',
  templateUrl: './play-video.component.html',
  styleUrls: ['./play-video.component.scss']
})
export class PlayVideoComponent implements OnInit {

  constructor( private videoService: VideoDetailsService) { }

  ngOnInit(): void {
  }

  video: Blob = null;

  displayVideo(id: Number) {
    console.log("DisplayVideo");
    this.videoService.getVideo(id).subscribe(resp => {
      console.log(resp);
    });
  }



}
