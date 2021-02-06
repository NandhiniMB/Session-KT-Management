import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginSuccessComponent } from './login-success/login-success.component';
import { LoginComponent } from './login/login.component';
import { PlayVideoComponent } from './play-video/play-video.component';
import { RegistrationComponent } from './registration/registration.component';
import { UploadVideoComponent } from './upload-video/upload-video.component';
import {MenuComponent} from './menu/menu.component';
import {MainComponent} from './main/main.component';
import { ManageVideoComponent } from './manage-video/manage-video.component';
import {CategoryComponent} from './category/category.component';
import {AllCategoriesComponent} from './all-categories/all-categories.component';
import { ManageCategoryComponent } from './manage-category/manage-category.component';
const routes: Routes = [
  {path: '', pathMatch: "full", component:LoginComponent},
// <<<<<<< HEAD
  {path: 'home', component: MainComponent,
   children:[{path: '', pathMatch: "full", component:HomeComponent},
   {path:'upload',component:UploadVideoComponent}, {path: 'maintain',
    pathMatch: "full", component: ManageVideoComponent},
    {path: 'subs', pathMatch: "full", component: CategoryComponent},
    {path: 'categories',  component: ManageCategoryComponent}]},
 // {path: 'home', pathMatch: "full", component: MainComponent, children:[{path:'upload',component:UploadVideoComponent}]},
  {path: 'register', pathMatch: "full", component: RegistrationComponent},
  {path: 'login', pathMatch: "full", component: LoginComponent},
  
  {path: 'playVideo/:id', pathMatch:"full", component:PlayVideoComponent}
  
  // {path: 'menu', pathMatch: "full", component: MenuComponent},
 // {path: '', pathMatch: "full", component:HomeComponent}
  

//   {path: 'home/:email', pathMatch: "full", component: HomeComponent},
//   {path: 'register', pathMatch: "full", component: RegistrationComponent},
//   {path: 'login', pathMatch: "full", component: LoginComponent},
//   {path:'upload',pathMatch:"full",component:UploadVideoComponent},
  
// >>>>>>> 31daabaf04fc829f9c4e1f789b970f654914c9f8
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
