import { Component, OnInit } from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import { NgForm } from '@angular/forms';
import { RegistrationService } from '../registration.service';
import {AdminService} from '../service/admin.service';
import { User } from '../Models/User';
import {Admin} from '../Models/Admin';
// import { Route } from '@angular/compiler/src/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);

  passwordFormControl = new FormControl(null, [
    Validators.required,
    // Validators.email,
  ]);

  user: User = new User();
 
  message: String = '';
 

  constructor(private Regservice: RegistrationService,private router: Router) { }

  ngOnInit(): void {
  }

  loginUser() {
    // if(this.user.email !== '' || this.user.password !== ''){
      this.Regservice.loginUserFromRemote(this.user).subscribe(
        data => { 
          this.user=data;
          console.log("Response Received"+this.user.email);
          console.log("Response Received"+this.user.id);
          this.Regservice.setUser(this.user);
          this.router.navigate(['/home']);
        },
        error => {
          this.message = "Bad Credentials! Please try again with correct credentials!";
          console.log("Exception Occurred");
        }
      );


  }

  registerUser(){
    this.router.navigate(['/register']);
    console.log("navigated to register page");
  }
}
