import { Component, OnInit } from '@angular/core';
import { VideoDetailsService } from '../video-details.service';
import { ViewChild, ElementRef } from "@angular/core";
import { DomSanitizer } from '@angular/platform-browser';
import { SharedService } from '../shared.service';
import { VideoDTO } from '../Models/VideoDTO';
import { User } from '../Models/User';
import { Like } from '../Models/like';
import { RegistrationService } from '../registration.service';
import { Comment } from '../Models/comment';
import { PlayVideoService } from '../play-video.service';

@Component({
  selector: 'app-play-video',
  templateUrl: './play-video.component.html',
  styleUrls: ['./play-video.component.scss']
})
export class PlayVideoComponent implements OnInit {

  video: Blob = null;
  comment_text:string="";
  likeCount:number=0;
  videoDTO: VideoDTO  = null;
  prev_url: any;
  user: User = null;
  likedVid: Like;
  commentedVid: Comment = null;

  constructor( private videoService: VideoDetailsService, private sharedService: SharedService , private regservice: RegistrationService, private playVideoService: PlayVideoService) { }

  ngOnInit(): void {
    // this.prev_url = this.sharedService.getPrevUrl();
    this.videoDTO = this.sharedService.getVideoDTO();
    this.prev_url = "data:video/mp4;base64," + this.videoDTO.data;
    // this.userId = this.sharedService.getUserId();
    console.log(this.regservice.getUser());
    this.user = JSON.parse(this.regservice.getUser());
    console.log(this.user);
    this.likedVid = new Like(this.videoDTO, this.user);

  }

  @ViewChild("videoPlayer", { static: false }) videoplayer: ElementRef;
  isPlay: boolean = false;
  toggleVideo() {
    this.videoplayer.nativeElement.play();
  }
  playPause() {
    var myVideo: any = document.getElementById("my_video_1");
    if (myVideo.paused) myVideo.play();
    else myVideo.pause();
  }

  makeBig() {
    var myVideo: any = document.getElementById("my_video_1");
    myVideo.width = 1000;
    myVideo.height = 600;
  }

  makeSmall() {
    var myVideo: any = document.getElementById("my_video_1");
    myVideo.width = 500;
    myVideo.height = 300;
  }

  makeNormal() {
    var myVideo: any = document.getElementById("my_video_1");
    myVideo.width = 750;
    myVideo.height = 450;
  }

  skip(value) {
    let video: any = document.getElementById("my_video_1");
    video.currentTime += value;
  }

  restart() {
    let video: any = document.getElementById("my_video_1");
    video.currentTime = 0;
  }

  like(){
    console.log(this.likedVid);
    this.playVideoService.likeVideoFromRemote(this.likedVid).subscribe(resp => {
      this.likeCount++;
      console.log(this.likeCount);
    })
  }

  comment(){
    console.log(this.comment_text);
    this.commentedVid = new Comment(this.comment_text, this.user, this.videoDTO);
    this.playVideoService.commentVideoFromRemote(this.commentedVid).subscribe(resp => {
      console.log(this.commentedVid);
    })
    this.comment_text="";
  }




}
