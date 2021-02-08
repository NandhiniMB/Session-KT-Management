import { Component, OnInit } from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import { RegistrationService } from '../service/registration.service';
import { User } from '../Models/User';
import {MatDialog} from '@angular/material/dialog';
import { Router } from '@angular/router';
import { SharedService } from '../service/shared.service';
import { ForgotPasswordComponent } from '../forgot-password/forgot-password.component';

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
    
  ]);

  user: User = new User();
  email: String;
  message: String = '';

  constructor(private Regservice: RegistrationService,private router: Router, private sharedService: SharedService, public dialog: MatDialog) { }

  ngOnInit(): void {
  }

  loginUser() {
    
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

  openDialog(): void {
    const dialogRef = this.dialog.open(ForgotPasswordComponent, {
      width: '300px',
      data: {email: this.email}
    });
  
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.email = result;
    });
  }

}
