import { Injectable } from '@angular/core';
import { VideoDTO } from './Models/VideoDTO';

@Injectable({
  providedIn: 'root'
})
export class SharedService {

  videoDTO: VideoDTO;

  id: Number;

  constructor() { }

  setVideoDTO(videoDTO){
    this.videoDTO = videoDTO;
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
  
}
