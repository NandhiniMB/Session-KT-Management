import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DBFile } from './Models/dbfile';
import { VideoDTO } from './Models/VideoDTO';

@Injectable({
  providedIn: 'root'
})
export class VideoDetailsService {
  UPLOAD_VIDEO='/uploadFile';
  SAVE_DATA='/saveVideoData';
  GET_ALL_WORDS = '/getAll';
  GET_VIDEO = '/getVideo';
  BASE_URL='http://localhost:8080/video';

  file:File;

  constructor(private http:HttpClient) { }
  
  public upLoadFromRemote(file:File):Observable<any>{
    return this.http.post(this.BASE_URL+this.UPLOAD_VIDEO,file);
  }

  public upLoadDataFromRemote(dbfile: DBFile):Observable<any>{
    return this.http.post(this.BASE_URL+this.SAVE_DATA,dbfile);
  }

  getAll(): Observable<any> {
    return this.http.get(this.BASE_URL + this.GET_ALL_WORDS);
  }

  public getVideo(id: Number): Observable<Object>{
    return this.http.get(this.BASE_URL +'/'+ id);
  }

}
