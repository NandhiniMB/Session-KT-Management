import { Component, OnInit } from '@angular/core';
import { Category } from '../Models/Category';
import { Subscribe } from '../Models/Subscribe';
import { User } from '../Models/User';
import { RegistrationService } from '../registration.service';
import { SubscribeService } from '../subscribe.service';
import { VideoDetailsService } from '../video-details.service';

@Component({
  selector: 'app-all-categories',
  templateUrl: './all-categories.component.html',
  styleUrls: ['./all-categories.component.scss']
})
export class AllCategoriesComponent implements OnInit {
  categories:Array<Category>=[];
  user:User=null;
  isDisabled:Array<Boolean>=[];
  subscribedCategory:Subscribe=null;
  count=0;
  constructor(private service:VideoDetailsService, private regService:RegistrationService, private subscribeService:SubscribeService) { 
    // this.service.getAllCategory().subscribe(categories=>{
    //   this.categories=categories;
    //   console.log(categories);
    // });
  }

  ngOnInit(): void {
    this.service.getAllCategory().subscribe(async categories=>{
      this.categories=await categories;
      for(let i=0;i<this.categories.length;i++){
          this.isDisabled.push(true);
      }
      console.log(this.isDisabled);
      console.log(categories);
    });
    // setTimeout("hi",8000);
    // console.log(this.categories);
    this.user=JSON.parse(this.regService.getUser());
    // this.subscribedCategory=new Subscribe();
    // console.log("length"+this.categories.length);
    // for(let i=0;i<this.categories.length;i++){
    //   this.isDisabled.push(true);
    // }
    // console.log(this.isDisabled);
    console.log("hi");
  }
  displayedColumns: String[] = ['id', 'category', 'uploadTime','button'];

  subscribe(id:Number,index:number){
    console.log(index);
    this.categories.forEach(category=>{
      if(category.id===id){
        this.subscribedCategory=new Subscribe(category,this.user);
      }
    });
    console.log(id);
    console.log(this.subscribedCategory);
    this.subscribeService.subscribeCategoryFromRemote(this.subscribedCategory).subscribe(resp=>{
      console.log(resp);
      // this.isDisabled[index]=false;
      console.log(typeof index);
      console.log(this.isDisabled);
    })
    // this.subscribedCategory=new Subscribe(this.categories.);
}
}


// if(this.count===0){
//   console.log(this.categories);
//   for(let i=0;i<this.categories.length;i++){
//       this.isDisabled.push(true);
//     }
//     console.log(this.isDisabled);
//     this.count=1;
// }


