import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../Models/Category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  BASE_URL='http://localhost:8080';
  ADD_CATEGORY='/category/'
  
  constructor(private http:HttpClient) { }

  public addCategory(category:Category):Observable<any>{
    return this.http.post(this.BASE_URL+this.ADD_CATEGORY,category);
  }
}
