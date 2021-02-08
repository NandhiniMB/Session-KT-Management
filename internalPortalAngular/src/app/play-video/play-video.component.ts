import { Component, OnInit } from '@angular/core';
import { VideoDetailsService } from '../service/video-details.service';
import { ViewChild, ElementRef } from "@angular/core";
import { SharedService } from '../service/shared.service';
import { VideoDTO } from '../Models/VideoDTO';
import { User } from '../Models/User';
import { Like } from '../Models/like';
import { RegistrationService } from '../service/registration.service';
import { Comment } from '../Models/comment';
import { ReceiveComments } from '../Models/ReceiveComments';
import { Location } from '@angular/common';
import { PlayVideoService } from '../service/play-video.service';
import { ConfirmationDialogComponent } from '../confirmation-dialog/confirmation-dialog.component';
import { MatDialog} from '@angular/material/dialog';

@Component({
  selector: 'app-play-video',
  templateUrl: './play-video.component.html',
  styleUrls: ['./play-video.component.scss']
})
export class PlayVideoComponent implements OnInit {

  video: Blob = null;
  comment_text: string = "";
  likeCount: number = 0;
  videoDTO: VideoDTO = null;
  prev_url: any;
  user: User = null;
  likedVid: Like;
  commentedVid: Comment = null;
  comments: Array<ReceiveComments>;
  vid: Number;
  liked = false;
  Likes: Array<Like>;

  constructor(public dialog: MatDialog, private location: Location, private videoService: VideoDetailsService, private sharedService: SharedService, private regservice: RegistrationService, private playVideoService: PlayVideoService) {

  }

  ngOnInit(): void {

    this.videoDTO = this.sharedService.getVideoDTO();
    this.prev_url = "data:video/mp4;base64," + this.videoDTO.data;

    console.log(this.regservice.getUser());
    this.user = JSON.parse(this.regservice.getUser());
    console.log(this.user);
    this.likedVid = new Like(this.videoDTO, this.user);
    this.liked = this.likedVid.liked;
    this.vid = this.sharedService.getVid();
    console.log(this.vid);
    this.videoService.getNumberOfComments(this.vid).subscribe(resp => {
      this.comments = resp;
      console.log(this.comments);
    })

    this.playVideoService.getAllLikes().subscribe(
      resp => {
        this.Likes = resp;
        console.log(this.Likes);

        for (let i = 0; i < this.Likes.length; i++) {

          if (this.Likes[i].video.id === this.videoDTO.id) {
            this.likeCount = this.likeCount + 1;
          }
          if (this.Likes[i].likedUser.id === this.user.id && this.Likes[i].video.id === this.videoDTO.id) {
            this.liked = true;
          }
        }
      }
    );

  }

  back() {
    this.location.back();
  }

  report() {
    this.videoService.reportVideo(this.videoDTO.id, this.user.id).subscribe(resp => {

      console.log(resp);
    })
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

  like() {
    console.log(this.likedVid);
    this.playVideoService.likeVideoFromRemote(this.likedVid).subscribe(resp => {
      this.likeCount++;
      console.log(this.likeCount);
      this.likedVid.liked = true;
      this.liked = true;
    })
  }

  unlike() {

    this.playVideoService.getAllLikes().subscribe(
      resp => {
        this.Likes = resp;
        console.log(this.Likes);

        for (let i = 0; i < this.Likes.length; i++) {
          if (this.Likes[i].likedUser.id === this.user.id && this.Likes[i].video.id === this.videoDTO.id) {
            this.liked = false;
            console.log(this.Likes[i].id);
            this.playVideoService.deleteLike(this.Likes[i].id).subscribe(resp => {
              console.log(resp);
            })
          }
        }
        this.likeCount--;
      }
    );

  }

  videoEnd() {
    console.log("here");
    console.log(this.videoDTO);
    this.videoService.videoViewed(this.videoDTO).subscribe(resp => {
      console.log(resp);
      this.videoDTO.views = resp;
    })
  }
  comment() {
    console.log(this.comments);
    console.log(this.comment_text);
    this.commentedVid = new Comment(this.comment_text, this.user, this.videoDTO);
    this.playVideoService.commentVideoFromRemote(this.commentedVid).subscribe(resp => {
      console.log(this.commentedVid);
      this.comments.push(resp);
    })
    this.comment_text = "";

  }

  reportComment(id: Number) {
    this.videoService.reportComment(id, this.user.id).subscribe(resp => {

      console.log(resp);
    })
  }

  openConfirmationDialog(comment): void {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      width: '300px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
      if (result) {
        if (comment == null)
          this.report();
        else
          this.reportComment(comment);
      }
    });
  }

}
