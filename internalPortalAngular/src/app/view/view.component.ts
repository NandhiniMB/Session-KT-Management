import { Component, OnInit } from '@angular/core';
import { ViewChild, ElementRef } from "@angular/core";
import { DomSanitizer } from '@angular/platform-browser';


@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.scss']
})
export class ViewComponent implements OnInit {
  constructor(private sanitizer : DomSanitizer) {  
  }

  onSelectedFile(ev) {
    let file = ev.target.files[0];
    var URL = window.URL;
    this.prev_url = this.sanitizer.bypassSecurityTrustUrl(URL.createObjectURL(file));
    console.log(this.prev_url)
  }

  ngOnInit(): void {
  }

  comment_text:string="";
  likeCount:number=0;
  prev_url : any;


  name = "Angular";
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
    myVideo.width = 560;
  }

  makeSmall() {
    var myVideo: any = document.getElementById("my_video_1");
    myVideo.width = 320;
  }

  makeNormal() {
    var myVideo: any = document.getElementById("my_video_1");
    myVideo.width = 420;
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
    this.likeCount++;
    console.log(this.likeCount);
  }

  comment(){
    console.log(this.comment_text);
    this.comment_text="";
  }
















}
