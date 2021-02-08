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

  public getAdminList(): Observable<any>{
    
    return this.http.get(this.ADMIN);
  }
}
