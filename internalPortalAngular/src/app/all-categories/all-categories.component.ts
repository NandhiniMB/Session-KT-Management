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
  subscriptions:Array<Subscribe>;
  isSubscribed:Array<Boolean>=[];
  length:Number;
  ind:number;
  constructor(private service:VideoDetailsService, private regService:RegistrationService, private subscribeService:SubscribeService) { 
    // this.service.getAllCategory().subscribe( async categories=>{
    //   this.categories= await categories;
    //   console.log(categories);
    // });
  }

  ngOnInit(): void {

    this.service.getAllCategory().subscribe(async categories=>{
      this.categories=await categories;
      // for(let i=0;i<this.categories.length;i++){
      //     // this.subscribedCategory.isSubscribed.push(false);
      // }
      // console.log(this.subscribedCategory.isSubscribed);
      console.log(categories);
    });
    this.user=JSON.parse(this.regService.getUser());
    this.subscribeService.getAllSubscriptions(this.user.id).subscribe(async resp=>{
      this.subscriptions=await resp;
      console.log(resp);
      this.length=this.categories.length;
      for(let i=0;i<this.length;i++){
        this.isSubscribed.push(false);
  }
  console.log(this.isSubscribed);
  this.categories.forEach(category=>{
    console.log("hi");
  for(let i=0;i<this.subscriptions.length;i++){
    if(category.id===this.subscriptions[i].category.id){
        this.ind=this.subscriptions[i].category.id;
        this.isSubscribed[this.ind-1]=true;
        // alert(this.isSubscribed[i]);
    }
  }
  });
  console.log(this.isSubscribed);
    });
    // this.user=JSON.parse(this.regService.getUser());



    // this.subscribeService.getAllSubscriptions().subscribe(async resp=>{
    //   this.subscriptions=await resp;
    //   console.log(resp);
    // });
    // this.categories.forEach(category=>{
    //   for(let i=0;i<this.subscriptions.length;i++){
    //     if(category.id===this.subscriptions[i].category.id && this.user.id===this.subscriptions[i].subscriber.id){
    //         this.isSubscribed=true;
    //     }
    //   }
    // });
  //   for(let i=0;i<this.subscriptions.length;i++){
  //     this.categories.forEach(category=>{
  //       if(category.id===this.subscriptions[i].category.id && this.user.id===this.subscriptions[i].subscriber.id){
  //           this.isSubscribed=true;
  //     }
  //   });
  // }
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
      // this.subscriptions = this.subscriptions.filter(v => {return v.id!=});
      // this.subscribedCategory.isSubscribed=true;
      // this.isSubscribed=true;
      // this.subscribedCategory.isSubscribed[index]=true;
      // this.isDisabled[index]=false;
      // console.log(typeof index);
      // console.log(this.isDisabled);
    })
    window.location.reload();
    // this.subscribedCategory=new Subscribe(this.categories.);
}
unSubscribe(id:Number){
this.subscribeService.deleteSubscription(id,this.user.id).subscribe(resp=>{
  console.log(resp);
});
window.location.reload();
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

    //   for(let i=0;i<this.subscriptions.length;i++){
    //     this.categories.forEach(category=>{
    //       if(category.id===this.subscriptions[i].category.id && this.user.id===this.subscriptions[i].subscriber.id){
    //           this.isSubscribed=true;
    //     }
    //   });
    // }
