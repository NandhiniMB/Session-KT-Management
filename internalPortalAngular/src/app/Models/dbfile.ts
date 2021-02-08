import { Category } from "./Category";
import { User } from "./User";

export class DBFile {
    id:Number;
    title:String;
    description:String;
    creator:User;
    category:Category;
    status:String;
    is_archived:Boolean;
    created_on:Date;
    last_modified_on:Date;
    views:number;
    file1:File
    constructor(){}
}
