import { Component, OnInit } from '@angular/core';
import { Subscribe } from '../Models/Subscribe';
import { User } from '../Models/User';
import { RegistrationService } from '../service/registration.service';
import { SubscribeService } from '../service/subscribe.service';

@Component({
  selector: 'app-subscribed-categories',
  templateUrl: './subscribed-categories.component.html',
  styleUrls: ['./subscribed-categories.component.scss']
})
export class SubscribedCategoriesComponent implements OnInit {
  subscriptions: Array<Subscribe>;
  user: User = null;
  constructor(private subscribeService: SubscribeService, private regService: RegistrationService) { }

  ngOnInit(): void {
    this.user = JSON.parse(this.regService.getUser());
    this.subscribeService.getAllSubscriptions(this.user.id).subscribe(resp => {
      this.subscriptions = resp;
      console.log(resp);
    });
  }

  displayedColumns: String[] = ['id', 'category'];

}