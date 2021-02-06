import { Category } from "./Category";
import { User } from "./User";

export interface VideoDTO{
    id: Number;
     data: string;

     path: string;

     title: string;

     description: string;

    isArchived: boolean;
category:Category;
creator:User;
    createdOn: Date;

    lastModifiedOn: Date;

     status: string;

    // private User creator;


    // private Category category;
}