import { Component, OnInit } from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import { NgForm } from '@angular/forms';
import { RegistrationService } from '../registration.service';
import { User } from '../Models/User';
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
  email: String;
  constructor(private service: RegistrationService, private router: Router) { }

  ngOnInit(): void {
  }

  loginUser() {
    // if(this.user.email !== '' || this.user.password !== ''){
      // console.log(this.user);
      this.service.loginUserFromRemote(this.user).subscribe(
        data => { 
          console.log("Response Received");
          this.email = this.user.email;
          console.log(this.email);
          this.router.navigate(['/home', this.email]);
        },
        error => {
          this.message = "Bad Credentials! Please try again with correct credentials!";
          console.log("Exception Occurred");
        }
      );
    // }
  }

  registerUser(){
    this.router.navigate(['/register']);
    console.log("navigated to register page");
  }
}
