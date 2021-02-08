import { Component, OnInit } from '@angular/core';
import { VideoDetailsService } from '../service/video-details.service';
import { Router } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';
import { VideoDTO } from '../Models/VideoDTO';
import { ReportService } from '../service/report.service';
import { SharedService } from '../service/shared.service';
import { RegistrationService } from '../service/registration.service';
import { User } from '../Models/User';
import { ConfirmationDialogComponent } from '../confirmation-dialog/confirmation-dialog.component';
import { MatDialog} from '@angular/material/dialog';
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
  user: User = new User();
  constructor(public dialog: MatDialog, private router: Router, private sharedService: SharedService, private regService: RegistrationService, private VideoService: VideoDetailsService, private sanitizer: DomSanitizer, private ReportService: ReportService) { }

  ngOnInit(): void {
    this.user = JSON.parse(this.regService.getUser());
    this.VideoService.getReportedVideo().subscribe(resp => {
      console.log(resp);
      this.report = resp;
    })
  }

  onEdit(id: Number) {
    console.log(id);
    
  }

  onPlay(id: Number) {
    console.log(id);
    this.VideoService.getVideo(id).subscribe(resp => {
      const videoDTO: VideoDTO = resp as VideoDTO;
      console.log(resp);
      this.prev_url = "data:video/mp4;base64," + videoDTO.data;
      console.log("hi");
      
      this.sharedService.setVideoDTO(videoDTO);
      this.sharedService.setVid(id);
      this.router.navigate(['/playVideo', id]);

    });
  }
  onDelete(Video_id: Number, Report_id: Number) {

    this.VideoService.deleteVideo(Video_id).subscribe(resp => {
      
      console.log(resp);
      
    });

    this.report = this.report.filter(report => !(report.id == Report_id));
    console.log(this.report);
  }

  openConfirmationDialog(Video_id: Number, Report_id: Number): void {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      width: '300px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
      if (result) {
        this.onDelete(Video_id, Report_id)
      }
    });
  }

  displayedColumns: String[] = ['id', 'title', 'description', 'category', 'uploadTime', 'creator', 'play', 'delete'];
  
  dataSource = this.report;
}