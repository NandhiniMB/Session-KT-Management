import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DBFile } from './Models/dbfile';
import {Category} from './Models/Category';
import { VideoDTO } from './Models/VideoDTO';

@Injectable({
  providedIn: 'root'
})
export class VideoDetailsService {
  UPLOAD_VIDEO='/uploadFile';
  SAVE_DATA='/saveVideoData';
  GET_ALL_VIDEOS = '/getAll';
  GET_VIDEO = '/getVideo';
  GET_REPORTED_VIDEO = '/report/video';
  DELETE_VIDEO = '/video';
  GET_APPROVED_VIDEOS ='/video/approved';
  UPDATE_STATUS = '/video/updatestat';
  SEND_MAIL='/subs/sendmail';
  BASE_URL='http://localhost:8080/video';
  GET_CATEGORY='/category/';
  GET_SUBSCRIBED_VIDEOS='/video/subs'

  file:File;

  constructor(private http:HttpClient) { }
  
  public upLoadFromRemote(file:File):Observable<any>{
    return this.http.post(this.BASE_URL+this.UPLOAD_VIDEO,file);
  }

  public upLoadDataFromRemote(dbfile: DBFile):Observable<any>{
    return this.http.post(this.BASE_URL+this.SAVE_DATA,dbfile);
  }

  public getAll(): Observable<any> {
    return this.http.get(this.BASE_URL + this.GET_ALL_VIDEOS);
  }

  getAllCategory(): Observable<any>{
    return this.http.get('http://localhost:8080'+this.GET_CATEGORY);
  }

  
  // public getPending(): Observable<any> {
  //   return this.http.get(this.GET_PENDING_VIDEOS);
  // }

  public getAllApproved(): Observable<any> {
    return this.http.get(this.GET_APPROVED_VIDEOS);
  }

  public getVideo(id: Number): Observable<Object>{
    return this.http.get(this.BASE_URL +'/'+ id);
  }

  public getReportedVideo(): Observable<any>{
    return this.http.get(this.GET_REPORTED_VIDEO);
  }

  public deleteVideo(id:Number) : Observable<any>{
    return this.http.delete(this.DELETE_VIDEO+'/'+id);
  }

  // public approveVideo(id:Number) : Observable<any>{
  //   return this.http.post(this.APPROVE_VIDEO,id);
  // }

  // public rejectVideo(id:Number) : Observable<any>{
  //   return this.http.post(this.REJECT_VIDEO,id);
  // }

  public UpdateStatus(video:DBFile) : Observable<any>{
      return this.http.put(this.UPDATE_STATUS,video);
    }

  public sendSubscriptionMail(video:DBFile,category:Category)
  {
    return this.http.post(this.SEND_MAIL,{video,category});
  }

  public getSubscribedVideos(id:Number):Observable<any>{
    return this.http.get(this.GET_SUBSCRIBED_VIDEOS+'/'+id);
  }

}
