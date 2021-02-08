import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../Models/User';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class RegistrationService {

  LOGIN = "/login";
  REGISTER = "/register";
  FORGOT_PASSWORD = "/forgotPassword";
  
  constructor(private http: HttpClient) { }
  user:User = new User();

  public setUser(user:User){
    
    this.user = user;
    localStorage.setItem('user',JSON.stringify(this.user));
  }
  public getUser(){
    return localStorage.getItem('user');
  }

  public removeUser(){
    localStorage.removeItem('user');
  }
  public loginUserFromRemote(user: User): Observable<any>{
    // console.log("remote" + user.email + user.password);
   return this.http.post("http://localhost:8080" + this.LOGIN, user);
  }

  public registerUserFromRemote(user: User): Observable<any> {
    return this.http.post("http://localhost:8080" + this.REGISTER, user);
  }

  public forgotPassword(email: String): Observable<any> {
    console.log(email);
    return this.http.put("http://localhost:8080" + this.FORGOT_PASSWORD, email);
  }
}
