import { Component, OnInit } from '@angular/core';
import { Category } from '../Models/Category';
import { VideoDetailsService } from '../video-details.service';

@Component({
  selector: 'app-all-categories',
  templateUrl: './all-categories.component.html',
  styleUrls: ['./all-categories.component.scss']
})
export class AllCategoriesComponent implements OnInit {
  categories:Array<Category>=[];
  constructor(private service:VideoDetailsService) { }

  ngOnInit(): void {
    this.service.getAllCategory().subscribe(categories=>{
      this.categories=categories;
      console.log(categories);
    });
  }
  displayedColumns: String[] = ['id', 'category', 'uploadTime','button'];

}


