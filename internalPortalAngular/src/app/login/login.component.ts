import { Component, OnInit } from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import { NgForm } from '@angular/forms';
import { RegistrationService } from '../registration.service';
import {AdminService} from '../service/admin.service';
import { User } from '../Models/User';
import {Admin} from '../Models/Admin';
// import { Route } from '@angular/compiler/src/core'
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { Router } from '@angular/router';
import { SharedService } from '../shared.service';
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
    // Validators.email,
  ]);


  user: User = new User();
  email: String;
  message: String = '';

// <<<<<<< HEAD
 
// =======================================================================

  constructor(private Regservice: RegistrationService,private router: Router, private sharedService: SharedService, public dialog: MatDialog) { }
// =======
//   email: String;
//   constructor(private service: RegistrationService, private router: Router) { }
// >>>>>>> 31daabaf04fc829f9c4e1f789b970f654914c9f8

  ngOnInit(): void {
  }

  loginUser() {
    // if(this.user.email !== '' || this.user.password !== ''){
// <<<<<<< HEAD
      this.Regservice.loginUserFromRemote(this.user).subscribe(
        data => { 
          this.user=data;
          console.log("Response Received"+this.user.email);
          console.log("Response Received"+this.user.id);
          // this.sharedService.setUserId(this.user.id);
          this.Regservice.setUser(this.user);
          this.router.navigate(['/home']);
// =======
//       // console.log(this.user);
//       this.service.loginUserFromRemote(this.user).subscribe(
//         data => { 
//           console.log("Response Received");
//           this.email = this.user.email;
//           console.log(this.email);
//           this.router.navigate(['/home', this.email]);
// >>>>>>> 31daabaf04fc829f9c4e1f789b970f654914c9f8
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
