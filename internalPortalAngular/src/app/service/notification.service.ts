import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NotificationService  {

  notifyCount:BehaviorSubject<any>=new BehaviorSubject<any>(0);

  notificationCount:any;

  constructor(private http : HttpClient) { this.notifyCount.subscribe(count => {
    this.notificationCount = count;
    console.log(count);
  }); }

  public updateNotifyCount(count){
    this.notifyCount.next(count);
  }

  public decrementCount(){
   this.notificationCount=this.notificationCount-1; 
   this.updateNotifyCount(this.notificationCount);
  }

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
