import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginSuccessComponent } from './login-success/login-success.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { UploadVideoComponent } from './upload-video/upload-video.component';
import {MenuComponent} from './menu/menu.component';
import {MainComponent} from './main/main.component';
import { ManageVideoComponent } from './manage-video/manage-video.component';
import {CategoryComponent} from './category/category.component';
const routes: Routes = [
  {path: '', pathMatch: "full", component:LoginComponent},
  {path: 'home', component: MainComponent, children:[{path: '', pathMatch: "full", component:HomeComponent},{path:'upload',component:UploadVideoComponent}, {path: 'maintain', pathMatch: "full", component: ManageVideoComponent}, {path: 'categories', pathMatch: "full", component: CategoryComponent}]},
 // {path: 'home', pathMatch: "full", component: MainComponent, children:[{path:'upload',component:UploadVideoComponent}]},
  {path: 'register', pathMatch: "full", component: RegistrationComponent},
  {path: 'login', pathMatch: "full", component: LoginComponent},
  
 
  
  // {path: 'menu', pathMatch: "full", component: MenuComponent},
 // {path: '', pathMatch: "full", component:HomeComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
