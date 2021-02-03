import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {Admin} from '../Models/Admin';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  
  ADMIN = "/admin/";
  admins:Array<any>
  constructor(private http: HttpClient) { }

 
  

  // async getIsAdmin(id:Number,){

  //   let isAdmin = false;
    
  //   this.getAdminList().subscribe(async admins => {
  //     this.admins = admins;  
  //     console.log("Admin"+JSON.stringify(this.admins));
  //     await this.admins.forEach(function (admin) { 
  //       if(id==admin.user.id)
  //        {
  //          console.log("here");
  //          isAdmin=true;
  //        }
  //   });   
  //   })

  //   console.log(isAdmin);
  //  return isAdmin;
    
 // }

  public getAdminList(): Observable<any>{
    // console.log("remote" + user.email + user.password);
    return this.http.get(this.ADMIN);
  }
}
