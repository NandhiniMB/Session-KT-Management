import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Comment } from './Models/comment';
import { Like } from './Models/like';

@Injectable({
  providedIn: 'root'
})
export class PlayVideoService {

  BASE_URL='http://localhost:8080/';

  LIKED_VIDEO = "likes";
  COMMENTED_VIDEO = "comments";

  constructor(private http:HttpClient) { }

  public likeVideoFromRemote(like: Like):Observable<any>{
    console.log(like);
    return this.http.post(this.BASE_URL + this.LIKED_VIDEO,like);
  }

  public commentVideoFromRemote(comment: Comment):Observable<any>{
    console.log(comment);
    return this.http.post(this.BASE_URL + this.COMMENTED_VIDEO,comment);
  }
  
}
