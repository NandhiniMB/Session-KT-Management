import { User } from "./User";
import { VideoDTO } from "./VideoDTO";

export class Like {
    id: Number;
    likedAt: Date;
    video: VideoDTO;
    user: User;

    constructor(video: VideoDTO, user: User) {
        this.video = video;
        this.user = user;
    }

}   