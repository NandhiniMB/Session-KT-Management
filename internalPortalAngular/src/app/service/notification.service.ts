import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor(private http : HttpClient) { }

  GET_NOTIFICATION = "/notify";
  PUT_ISREAD = "/notify/read"

  public getNotifications(id:Number):Observable<any>{
    return this.http.get(this.GET_NOTIFICATION+'/'+ id);
  }

  public ReadNotifications(notification:any):Observable<any>{
    console.log("in req");
    return this.http.put(this.PUT_ISREAD,notification)
  }
}
