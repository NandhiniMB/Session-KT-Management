import { Component, OnInit } from '@angular/core';
import { Category } from '../Models/category';
import { VideoDetailsService } from '../service/video-details.service';
export interface Tile {
  color: string;
  cols: number;
  rows: number;
  text: string;
}

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.scss']
})
export class CategoryComponent implements OnInit {
  categories:Array<Category>=[];
  constructor(private service:VideoDetailsService) { }

  ngOnInit(): void {
    this.service.getAllCategory().subscribe(categories=>{
      this.categories=categories;
      // console.log(categories);
    });
  }
  
  tiles: Tile[] = [
    {text: 'One', cols: 3, rows: 8, color: 'lightblue'},
    {text: 'Two', cols: 1, rows: 4, color: 'lightgreen'},
    // {text: 'Three', cols: 1, rows: 1, color: 'lightpink'},
    {text: 'Four', cols: 1, rows: 4, color: '#DDBDF1'},
  ];

  displayedColumns: String[] = ['id', 'category', 'uploadTime'];
}
