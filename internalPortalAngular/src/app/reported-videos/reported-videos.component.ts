import { Component, OnInit } from '@angular/core';
import { VideoDetailsService } from '../video-details.service';
import { DBFile } from '../Models/dbfile';
import { Router } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';
import { VideoDTO } from '../Models/VideoDTO';
import { ReportService } from '../service/report.service';
import {SharedService} from '../shared.service';
import { RegistrationService } from '../registration.service';
import { User } from '../Models/User';
@Component({
  selector: 'app-reported-videos',
  templateUrl: './reported-videos.component.html',
  styleUrls: ['./reported-videos.component.scss']
})
export class ReportedVideosComponent implements OnInit {

  report: Array<any> = [];

  image = null;
  imageToShow = null;

  prev_url: any;
  user:User=new User();
  constructor(private router: Router,private sharedService: SharedService,private regService:RegistrationService, private VideoService: VideoDetailsService, private sanitizer : DomSanitizer,private ReportService: ReportService) { }


 
  ngOnInit(): void {
    this.user=JSON.parse(this.regService.getUser());
    this.VideoService.getReportedVideo().subscribe(resp => {
      console.log(resp);
      this.report = resp;
    })
  }


  onEdit(id: Number) {
    console.log(id);
    // this.VideoService.getVideo(id).subscribe(resp => {
    //   const videoDTO: VideoDTO = resp as VideoDTO;
    //   console.log(resp);
    //   this.prev_url = "data:video/mp4;base64," + videoDTO.data;
    //   console.log("hi");
      
   // });
  }

  onPlay(id: Number) {
    console.log(id);
    this.VideoService.getVideo(id).subscribe(resp => {
      const videoDTO: VideoDTO = resp as VideoDTO;
      console.log(resp);
      this.prev_url = "data:video/mp4;base64," + videoDTO.data;
      console.log("hi");
      // this.sharedService.setPrevUrl(this.prev_url);
      this.sharedService.setVideoDTO(videoDTO);
      this.router.navigate(['/playVideo',id]);
      
    });
  }
  onDelete(Video_id: Number,Report_id:Number) {
  
  
    this.ReportService.deleteReport(Report_id).subscribe(resp => {
      // const videoDTO: VideoDTO = resp as VideoDTO;
      console.log(resp);
      // this.prev_url = "data:video/mp4;base64," + videoDTO.data;
      // console.log("hi");
      
   });
    this.VideoService.deleteVideo(Video_id).subscribe(resp => {
    //  const videoDTO: VideoDTO = resp as VideoDTO;
      console.log(resp);
      // this.prev_url = "data:video/mp4;base64," + videoDTO.data;
      // console.log("hi");
      
   });

   this.report=this.report.filter(report => !( report.id == Report_id));
   console.log(this.report);
  }

  displayedColumns: String[] = ['id', 'title','description', 'category', 'uploadTime','creator', 'play' , 'delete'];
  //displayedColumns: String[] = ['id', 'title','description', 'category', 'uploadTime','uploadBy','reportBy', 'play'];
  dataSource = this.report;
  }


