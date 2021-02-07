import { User } from "./User";
import { VideoDTO } from "./VideoDTO";

export class Like {
    id: Number;
    likedAt: Date;
    video: VideoDTO;
    likedUser: User;
    liked: boolean;

    constructor(video: VideoDTO, user: User) {
        this.video = video;
        this.likedUser = user;
        this.liked = false;
    }

}   