import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import {AdminService} from '../service/admin.service';
import {Admin} from '../Models/Admin';
import { User } from '../Models/User';
import { RegistrationService } from '../registration.service';
import {NotificationService} from '../service/notification.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

 
  constructor(private router: Router,private AdminService: AdminService,private RegService : RegistrationService,private NotificationService:NotificationService ) { }
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
  })

  }
  public logoutUser() {

    this.RegService.removeUser();
    this.router.navigate(['/login']);
    console.log("navigated to login page");
   
  }
 
}
