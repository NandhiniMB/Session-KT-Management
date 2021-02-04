import { User } from "./User";
import { VideoDTO } from "./VideoDTO";

export class Comment{
    comment: String;
    commentedOn: Date;
    commentor: User;
    video: VideoDTO;

    constructor(comment: String, commentor: User, video: VideoDTO){
        this.comment = comment;
        this.commentor = commentor;
        this.video = video;
    }
}