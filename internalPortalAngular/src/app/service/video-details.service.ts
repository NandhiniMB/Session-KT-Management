import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DBFile } from '../Models/dbfile';
import {Category} from '../Models/Category';
import { VideoDTO } from '../Models/VideoDTO';

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
  DELETE_COMMENT = '/comment';
  GET_APPROVED_VIDEOS ='/video/approved';
  UPDATE_STATUS = '/video/updatestat';
  SEND_MAIL='/subs/sendmail';
  BASE_URL='http://localhost:8080/video';
  COMMENTS='/comments';
  EDIT_DETAILS = '/editDetails';

  GET_CATEGORY='/category/';
  GET_SUBSCRIBED_VIDEOS='/video/subs';
  UPDATE_CATEGORY='/category/';
  ADD_CATEGORY='/category/';
  DELETE_CATEGORY = '/category';
  REPORT_VIDEO = '/report/';
  REPORT_COMMENT = '/report/comment';
  GET_REPORTED_COMMENT='/report/getcomment';
  GET_PENDING_VIDEOS='/video/pending';
  file:File;

  VIEW_VIDEO = '/video/view'

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

  
  public getPending(): Observable<any> {
    return this.http.get(this.GET_PENDING_VIDEOS);
  }

  

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

  public deleteComment(id:Number) : Observable<any>{
    return this.http.delete(this.DELETE_COMMENT+'/'+id);
  }

  public reportVideo(video_id:Number,user_id:Number):Observable<any>{
    return this.http.get(this.REPORT_VIDEO+'/'+video_id+'/'+user_id);
  }

  public reportComment(comment_id,user_id:Number):Observable<any>{
    return this.http.get(this.REPORT_COMMENT+'/'+comment_id+'/'+user_id);
  }
  public getReportedComment(): Observable<any>{
    return this.http.get(this.GET_REPORTED_COMMENT);
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

    public EditDetails(video:DBFile) : Observable<any>{
      return this.http.put(this.BASE_URL + this.EDIT_DETAILS,video);
    }

  public sendSubscriptionMail(video:DBFile,category:Category)
  {
    return this.http.post(this.SEND_MAIL,{video,category});
  }



  public getNumberOfComments(vid:Number): Observable<any>{

    console.log(vid);
    return this.http.get('http://localhost:8080'+this.COMMENTS+'/'+vid);
  }



  
  public getSubscribedVideos(id:Number):Observable<any>{
    return this.http.get(this.GET_SUBSCRIBED_VIDEOS+'/'+id);
  }

  public addCategory(category:Category):Observable<any>{
    return this.http.post(this.ADD_CATEGORY,category)
  }

  public updateCategory(category:Category):Observable<any>{
    return this.http.post(this.UPDATE_CATEGORY,category)
  }

  public deleteCategory(id:Number):Observable<any>{
    return this.http.delete(this.DELETE_CATEGORY+'/'+id);
  }

  public videoViewed(video:VideoDTO):Observable<any>{
    return this.http.post(this.VIEW_VIDEO,video);
  }
}
