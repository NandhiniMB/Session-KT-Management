import { Category } from "./category";

export class DBFile {
    id:Number;
    title:String;
    description:String;
    category:Category;
    is_archived:Boolean;
    created_on:Date;
    last_modified_on:Date;
    status:String;
    file1:File
    constructor(){}
}