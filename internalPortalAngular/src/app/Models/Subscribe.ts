import { Category } from "./Category";
import { User } from "./User";

export class Subscribe{
    id:Number;
    category:Category;
    subscriber:User;
    constructor(category:Category,subscriber:User){
        this.category=category;
        this.subscriber=subscriber;
    }
}