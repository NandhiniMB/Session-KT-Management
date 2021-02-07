import { Category } from "./Category";
import { User } from "./User";

export class Subscribe{
    id:number;
    category:Category;
    subscriber:User;
    isSubscribed:Boolean;
    // isSubscribed:Array<Boolean>;
    constructor(category:Category,subscriber:User){
        this.category=category;
        this.subscriber=subscriber;
        this.isSubscribed=false;
        // this.isSubscribed=[];
    }
}