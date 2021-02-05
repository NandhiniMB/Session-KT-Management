import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

// import {AfterViewInit, ViewChild} from '@angular/core';
// import {MatPaginator} from '@angular/material/paginator';
// import {MatTableDataSource} from '@angular/material/table';
// import { PeriodicElement } from '../Models/PeriodicElements';
import { VideoDetailsService } from '../video-details.service';
import { DBFile } from '../Models/dbfile';
// import { PlayVideoComponent } from '../play-video/play-video.component';
// import { Location } from '@angular/common';
import {AfterViewInit, ViewChild} from '@angular/core';
// import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { DomSanitizer } from '@angular/platform-browser';
import { VideoDTO } from '../Models/VideoDTO';
import { SharedService } from '../shared.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit{

  video: Array<DBFile> = [];

  image = null;
  imageToShow = null;

  prev_url: any;

  constructor(private router: Router, private videoService: VideoDetailsService, private sharedService: SharedService) { }

  ngOnInit(): void {
    this.videoService.getAllApproved().subscribe(resp => {
      console.log(resp);
      this.video = resp;
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
      // this.sharedService.setPrevUrl(this.prev_url);
      this.sharedService.setVideoDTO(videoDTO);
      this.router.navigate(['/playVideo',id]);

      this.sharedService.setVid(id);

      
    });
    // this.router.navigate(['/playVideo',id]);
    // this.playvideo.displayVideo(id);
  // })
}
  // interface PeriodicElement {
  //   name: string;
  //   position: number;
  //   weight: number;
  //   symbol: string;
  // }

  // ELEMENT_DATA: PeriodicElement[] = [
  //   {position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H'},
  //   {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
  //   {position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li'},
  //   {position: 4, name: 'Beryllium', weight: 9.0122, symbol: 'Be'},
  //   {position: 5, name: 'Boron', weight: 10.811, symbol: 'B'},
  //   {position: 6, name: 'Carbon', weight: 12.0107, symbol: 'C'},
  //   {position: 7, name: 'Nitrogen', weight: 14.0067, symbol: 'N'},
  //   {position: 8, name: 'Oxygen', weight: 15.9994, symbol: 'O'},
  //   {position: 9, name: 'Fluorine', weight: 18.9984, symbol: 'F'},
  //   {position: 10, name: 'Neon', weight: 20.1797, symbol: 'Ne'},
  // ];

  displayedColumns: String[] = ['id', 'title','description', 'category', 'uploadTime', 'play'];
  dataSource = this.video;
  // dataSource = new MatTableDataSource<DBFile>(this.video);

  // @ViewChild(MatPaginator) paginator: MatPaginator;

  // ngAfterViewInit() {
  //   this.dataSource.paginator = this.paginator;
  // }

}
