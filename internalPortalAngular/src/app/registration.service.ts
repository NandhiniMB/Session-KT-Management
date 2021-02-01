import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './Models/User';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class RegistrationService {

  LOGIN = "/login";
  REGISTER = "/register";

  constructor(private http: HttpClient) { }

  public loginUserFromRemote(user: User): Observable<any>{
    // console.log("remote" + user.email + user.password);
    return this.http.post("http://localhost:8080" + this.LOGIN, user);
  }

  public registerUserFromRemote(user: User): Observable<any> {
    return this.http.post("http://localhost:8080/" + this.REGISTER, user);
  }
}
