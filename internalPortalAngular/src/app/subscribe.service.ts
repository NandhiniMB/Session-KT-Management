import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Subscribe } from './Models/Subscribe';

@Injectable({
  providedIn: 'root'
})
export class SubscribeService {

  BASE_URL='http://localhost:8080';
  POST_SUBCRIBE='/subs/subscribe';

  constructor(private http:HttpClient) { }

  public subscribeCategoryFromRemote(subscribe:Subscribe):Observable<any>{
    console.log(subscribe);
    return this.http.post(this.BASE_URL+this.POST_SUBCRIBE,subscribe);
  }
}
