import { User } from "./User";
import { VideoDTO } from "./VideoDTO";

export class ReceiveComments{
    id:Number;
    comment: String;
    commentedOn: Date;
    commentor: User;
    video: VideoDTO;

    constructor(){}
    
}