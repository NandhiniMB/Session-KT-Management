import { Component, OnInit } from '@angular/core';
import { User } from '../Models/User';
import { RegistrationService } from '../service/registration.service';
import { VideoDetailsService } from '../service/video-details.service';
import { SharedService } from '../service/shared.service';
import { VideoDTO } from '../Models/VideoDTO';
import { Router } from '@angular/router';
import { ReportService } from '../service/report.service';
import { MatDialog} from '@angular/material/dialog';
import { ConfirmationDialogComponent } from '../confirmation-dialog/confirmation-dialog.component';
@Component({
  selector: 'app-reported-comments',
  templateUrl: './reported-comments.component.html',
  styleUrls: ['./reported-comments.component.scss']
})
export class ReportedCommentsComponent implements OnInit {

  constructor(public dialog: MatDialog, private ReportService: ReportService, private regService: RegistrationService, private router: Router, private videoService: VideoDetailsService, private SharedService: SharedService) { }

  user: User;
  report: Array<any> = [];
  prev_url: any;
  ngOnInit(): void {

    this.user = JSON.parse(this.regService.getUser());
    this.videoService.getReportedComment().subscribe(resp => {
      console.log(resp);
      this.report = resp;
    })
  }

  onPlay(id: Number) {
    console.log(id);
    this.videoService.getVideo(id).subscribe(resp => {
      const videoDTO: VideoDTO = resp as VideoDTO;
      console.log(resp);
      this.prev_url = "data:video/mp4;base64," + videoDTO.data;
      console.log("hi");

      this.SharedService.setVideoDTO(videoDTO);
      this.SharedService.setVid(id);
      this.router.navigate(['/playVideo', id]);

    });
  }
  onDelete(comment_id: Number, Report_id: Number) {

    this.ReportService.deleteReport(Report_id).subscribe(resp => {

      console.log(resp);

    });
    this.videoService.deleteComment(comment_id).subscribe(resp => {

      console.log(resp);

    });

    this.report = this.report.filter(report => !(report.id == Report_id));
    console.log(this.report);
  }

  openConfirmationDialog(Comment_id: Number, Report_id: Number): void {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      width: '300px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
      if (result) {
        this.onDelete(Comment_id, Report_id)
      }
    });
  }

  displayedColumns: String[] = ['id', 'comment', 'title', 'description', 'category', 'uploadTime', 'creator', 'play', 'delete'];

  dataSource = this.report;

}
