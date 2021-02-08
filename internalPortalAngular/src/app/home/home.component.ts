import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VideoDetailsService } from '../service/video-details.service';
import { DBFile } from '../Models/dbfile';
import {MatTableDataSource} from '@angular/material/table';
import { VideoDTO } from '../Models/VideoDTO';
import { SharedService } from '../service/shared.service';
import { RegistrationService } from '../service/registration.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit{

  video: Array<DBFile> = [];
  subscribedvideo : Array<DBFile> = [];
  image = null;
  imageToShow = null;
  mostViews:Array<any>= [];
 
  prev_url: any;
  displayedColumns: String[] = ['id', 'title','description','creator','views', 'category', 'uploadTime', 'play'];
  activeButton: 'all' | 'subscribed' | 'mostviewed' ='all';
  dataSource:any=this.video;

  constructor(private router: Router, private videoService: VideoDetailsService, private sharedService: SharedService,private RegService:RegistrationService) { }

  ngOnInit(): void {
    this.videoService.getAllApproved().subscribe(resp => {
      console.log(resp);
      this.video = resp;
      this.mostViews=this.video
      this.dataSource = this.video;
      console.log("on",this.dataSource);
  
    })
  
  }

  loginUser() {
    this.router.navigate(['/login']);
    console.log("navigated to login page");
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

onSelectAll(){
  this.dataSource = this.video;
  console.log("onSelect",this.dataSource);
  console.log("aLL"+this.video)

  this.activeButton = "all";
}
onSelectSubscribe(){
  this.subscribedvideo = this.video;
  let  user = JSON.parse(this.RegService.getUser());

  this.videoService.getSubscribedVideos(user.id).subscribe(resp => {
    console.log("subscribed"+resp);
    this.subscribedvideo = resp;
    this.dataSource = this.subscribedvideo;
    console.log("subs",this.dataSource);
  
  })
  this.activeButton = "subscribed";
 
}

onSelectMostViewed(){

  this.activeButton = "mostviewed";
  this.mostViews=this.video;
  this.mostViews=this.mostViews.sort((a, b) => (a.views > b.views ? -1:1));
  console.log("in most viwed")
  console.log(this.mostViews);
  this.mostViews=this.mostViews.slice(0,5);
  this.dataSource=new MatTableDataSource(this.mostViews);
  console.log("mostView",this.dataSource);
  
}
  
}
