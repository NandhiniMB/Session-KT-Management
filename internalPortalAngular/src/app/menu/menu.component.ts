import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import {AdminService} from '../service/admin.service';
import {Admin} from '../Models/Admin';
import { User } from '../Models/User';
import { RegistrationService } from '../registration.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

 
  constructor(private router: Router,private AdminService: AdminService,private RegService : RegistrationService ) { }
  admins : Array<Admin>;
  user  : User = new User()
  ngOnInit(): void {
  this.user = this.RegService.getUser()
  console.log(this.user.id);
  console.log(this.user.email);
  this.AdminService.getAdminList().subscribe(admins => {
      this.admins = admins;  
      console.log("Admin"+JSON.stringify(this.admins));
    }
)
  }
  public loginUser() {
    this.router.navigate(['/login']);
    console.log("navigated to login page");
   
  }
 
}