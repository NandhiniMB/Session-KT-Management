import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../Models/User';
import { RegistrationService } from '../service/registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent implements OnInit {

  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);

  passwordFormControl = new FormControl(null, [
    Validators.required,

  ]);

  usernameFormControl = new FormControl(null, [
    Validators.required,

  ]);

  nameFormControl = new FormControl(null, [
    Validators.required,

  ]);

  user: User = new User();

  message: String = '';


  constructor(private service: RegistrationService, private router: Router) { }

  ngOnInit(): void {
  }

  registerUser() {
    this.service.registerUserFromRemote(this.user).subscribe(
      data => {
        console.log("Response Received");
        this.router.navigate(['/login']);
      },
      error => {
        this.message = "The Email Id already Exists!!";
        console.log("Exception Occurred");
      }
    );
  }

  loginUser() {
    this.router.navigate(['/login']);
    console.log("navigated to login page");
  }

}