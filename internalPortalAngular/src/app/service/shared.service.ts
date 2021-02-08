import { Injectable } from '@angular/core';
import { DBFile } from '../Models/dbfile';
import { User } from '../Models/User';
import { VideoDTO } from '../Models/VideoDTO';

@Injectable({
  providedIn: 'root'
})
export class SharedService {

  videoDTO: VideoDTO;

  id: Number;

  user: User;

  vid:Number;

  editVideo: DBFile;

  constructor() { }

  setVideoDTO(videoDTO){
    this.videoDTO = videoDTO;
  }

  setVid(vid){
    this.vid = vid;
  }

  getVid(){
    return this.vid;
  }

  getVideoDTO(){
    return this.videoDTO;
  }

  setUserId(id) {
    this.id = id;
  }

  getUserId(){
    return this.id;
  }

  setEditVideo(video){
    this.editVideo = video;
  }

  getEditVideo(){
    return this.editVideo;
  }
  
}

