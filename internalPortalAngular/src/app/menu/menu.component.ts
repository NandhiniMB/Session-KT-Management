import { Component, OnInit, Input,Inject } from '@angular/core';
import { Router } from '@angular/router';
import {AdminService} from '../service/admin.service';
import {Admin} from '../Models/Admin';
import { User } from '../Models/User';
import { RegistrationService } from '../registration.service';
import {NotificationService} from '../service/notification.service';
import {MatDialog, MAT_DIALOG_DATA} from '@angular/material/dialog';

import { BrowserModule } from '@angular/platform-browser'
// export interface notification{
//  notification:this.notif
// }

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})


export class MenuComponent implements OnInit {


  notifications : Array<any> ;

  constructor(public dialog: MatDialog,private router: Router,private AdminService: AdminService,private RegService : RegistrationService,private NotificationService:NotificationService ) { }
  admins : Array<Admin>;
  user  : User = new User()
  ngOnInit(): void {
  this.user = JSON.parse(this.RegService.getUser());
  console.log(this.user.id);
  console.log(this.user.email);
  this.AdminService.getAdminList().subscribe(admins => {
      this.admins = admins;  
      console.log("Admin"+JSON.stringify(this.admins));
    }
  )
  this.NotificationService.getNotifications(this.user.id).subscribe(notification => {
    console.log(notification);
    this.notifications = notification;
  })

  }

  public openNotificationDialog() {
    const dialogRef = this.dialog.open(NotificationDialog);

    // dialogRef.afterClosed().subscribe(result => {
    //   console.log(`Dialog result: ${result}`);
    // });
  }
  public logoutUser() {

    this.RegService.removeUser();
    this.router.navigate(['/login']);
    console.log("navigated to login page");
   
  }
 
}

@Component({
  selector: 'notification-dialog',
  templateUrl: 'notification-dialog.html',
})
// export class NotificationDialog {
//   constructor(@Inject(MAT_DIALOG_DATA) public data: notifications) {}
// }
export class NotificationDialog {

  constructor(private NotificationService:NotificationService , private RegService : RegistrationService) { 

  }

  notifications : Array<any> ;

  user  : User = new User()
  ngOnInit(): void {

    this.user = JSON.parse(this.RegService.getUser());
    console.log(this.user.id);
    this.NotificationService.getNotifications(this.user.id).subscribe(notification => {
      console.log(notification);
      this.notifications = notification;
    })

  }
   public OnNotificationsRead(notification:any){

    let notify_id=notification.id;
    this.NotificationService.ReadNotifications(notification).subscribe(notification => {
      console.log(notification);
      this.notifications = this.notifications.filter(notification=> !( notification.id== notify_id));
    })
  
   }

  
}