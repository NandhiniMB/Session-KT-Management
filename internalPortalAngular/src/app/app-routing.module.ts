import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { PlayVideoComponent } from './play-video/play-video.component';
import { RegistrationComponent } from './registration/registration.component';
import { UploadVideoComponent } from './upload-video/upload-video.component';
import { MainComponent } from './main/main.component';
import { ManageVideoComponent } from './manage-video/manage-video.component';
import { CategoryComponent } from './category/category.component';
import { ManageCategoryComponent } from './manage-category/manage-category.component';
import { MyVideosComponent } from './my-videos/my-videos.component';
const routes: Routes = [
  { path: '', pathMatch: "full", component: LoginComponent },
  {
    path: 'home', component: MainComponent,
    children: [
      { path: '', pathMatch: "full", component: HomeComponent },
      { path: 'upload', component: UploadVideoComponent },
      { path: 'maintain', pathMatch: "full", component: ManageVideoComponent },
      { path: 'subs', pathMatch: "full", component: CategoryComponent },
      { path: 'categories', component: ManageCategoryComponent },
      { path: 'videos', component: MyVideosComponent }]
  },

  { path: 'register', pathMatch: "full", component: RegistrationComponent },
  { path: 'login', pathMatch: "full", component: LoginComponent },
  { path: 'playVideo/:id', pathMatch: "full", component: PlayVideoComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }