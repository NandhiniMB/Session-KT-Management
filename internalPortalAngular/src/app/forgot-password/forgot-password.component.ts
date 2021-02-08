import { Component, OnInit } from '@angular/core';
import { RegistrationService } from '../service/registration.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.scss']
})
export class ForgotPasswordComponent implements OnInit {

  email: String;
  message: String = '';
  constructor(private regService: RegistrationService) { }

  ngOnInit(): void {
  }

  onForgotPassword() {
    console.log(this.email);
    this.regService.forgotPassword(this.email).subscribe(resp => {console.log(resp)});
    this.message = 'Your Password has been sent to you!';
  }

}
