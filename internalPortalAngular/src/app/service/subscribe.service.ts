import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Subscribe } from '../Models/Subscribe';
import { User } from '../Models/User';

@Injectable({
  providedIn: 'root'
})
export class SubscribeService {

  BASE_URL='http://localhost:8080';
  POST_SUBCRIBE='/subs/subscribe';
  GET_SUBSCRIPTIONS='/subs/getSubscriptions';
  DELETE_SUBCRIPTION='/subs/deleteSubscription'

  constructor(private http:HttpClient) { }

  public subscribeCategoryFromRemote(subscribe:Subscribe):Observable<any>{
    console.log(subscribe);
    return this.http.post(this.BASE_URL+this.POST_SUBCRIBE,subscribe);
  }

  public getAllSubscriptions(id:Number): Observable<any>{
    return this.http.get(this.BASE_URL + this.GET_SUBSCRIPTIONS+"/"+id);
  }

  public deleteSubscription(catId:Number,userId:Number):Observable<any>{
    return this.http.delete(this.BASE_URL+this.DELETE_SUBCRIPTION+'/'+catId+'/'+userId);
  }
}
