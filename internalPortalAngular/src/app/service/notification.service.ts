import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor(private http : HttpClient) { }

  GET_NOTIFICATION = "/notify";

  public getNotifications(id:Number):Observable<any>{
    return this.http.get(this.GET_NOTIFICATION+'/'+ id);
  }
}
