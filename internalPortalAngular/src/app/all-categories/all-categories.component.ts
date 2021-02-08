import { Component, OnInit } from '@angular/core';
import { Category } from '../Models/Category';
import { Subscribe } from '../Models/Subscribe';
import { User } from '../Models/User';
import { RegistrationService } from '../service/registration.service';
import { SubscribeService } from '../service/subscribe.service';
import { VideoDetailsService } from '../service/video-details.service';

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
  constructor(private service:VideoDetailsService, private regService:RegistrationService, private subscribeService:SubscribeService) { }

  ngOnInit(): void {

    this.service.getAllCategory().subscribe( categories=>{
      this.categories= categories;
      console.log(categories);
    });
    this.user=JSON.parse(this.regService.getUser());
    this.subscribeService.getAllSubscriptions(this.user.id).subscribe( resp=>{
      this.subscriptions= resp;
      this.length=this.categories.length;
      for(let i=0;i<this.length;i++){
        this.isSubscribed.push(false);
  }
  console.log(this.isSubscribed);
  for(let i=0;i<this.categories.length;i++){
    for(let j=0;j<this.subscriptions.length;j++){
      if(this.categories[i].id===this.subscriptions[j].category.id){
        this.isSubscribed[i]=true;
      }
  // this.categories.forEach(category=>{
  // for(let i=0;i<this.subscriptions.length;i++){
  //   if(category.id===this.subscriptions[i].category.id){
  //       this.ind=this.subscriptions[i].category.id;
  //       this.isSubscribed[this.ind - 1]=true;
  //   }
  // }
  // console.log(this.isSubscribed);
  //   });
  }
}
    });
  }

  displayedColumns: String[] = ['id', 'category', 'uploadTime','button'];

  subscribe(id: Number, index: number) {
    console.log(index);
    this.categories.forEach(category => {
      if (category.id === id) {
        this.subscribedCategory = new Subscribe(category, this.user);
      }
    });
    console.log(id);
    console.log(this.subscribedCategory);
    this.subscribeService.subscribeCategoryFromRemote(this.subscribedCategory).subscribe(resp => {
      console.log(resp);
    })
    window.location.reload();
}
unSubscribe(id:Number){
this.subscribeService.deleteSubscription(id,this.user.id).subscribe(resp=>{
  console.log(resp);
});
window.location.reload();
}
}
