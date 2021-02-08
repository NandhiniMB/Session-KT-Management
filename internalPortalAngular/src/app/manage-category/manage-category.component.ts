import { Component, OnInit } from '@angular/core';
import { Category } from '../Models/Category';
import { VideoDetailsService } from '../service/video-details.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-manage-category',
  templateUrl: './manage-category.component.html',
  styleUrls: ['./manage-category.component.scss']
})
export class ManageCategoryComponent implements OnInit {

  constructor(private videoService: VideoDetailsService) { }

  loadEditComponent: boolean = false;
  c: Category = new Category();
  selectedCategory: Category = new Category();
  categories: Array<Category>;
  category_name: String;
  ngOnInit(): void {
    this.videoService.getAllCategory().subscribe(categories => {
      this.categories = categories;
      console.log(categories);
    });
  }

  onAdd(f: NgForm) {
    console.log(f.value.category_name);

    this.c.categoryName = f.value.category_name;
    this.videoService.addCategory(this.c).subscribe(category => {
      console.log(category);
      this.categories.push(category);
      this.category_name = ' ';
    });


  }


  onDelete(id: Number) {
    let old_id = id;
    this.videoService.deleteCategory(id).subscribe(resp => {
      console.log(resp);
      this.categories = this.categories.filter(category => {
        return category.id != old_id;
      })
    })

  }
  onEdit(category: Category) {
    this.selectedCategory = category
    console.log("selected" + this.selectedCategory.id);
    console.log("selected" + this.selectedCategory.categoryName);
    this.loadEditComponent = true;
  }
  edit(f: NgForm) {
    this.loadEditComponent = false;
    this.c.id = this.selectedCategory.id;
    this.c.categoryName = f.value.new_category_name;
    this.videoService.updateCategory(this.c).subscribe(category => {
      console.log(category);

    })
  }
}