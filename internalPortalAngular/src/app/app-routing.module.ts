import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginSuccessComponent } from './login-success/login-success.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { UploadVideoComponent } from './upload-video/upload-video.component';

const routes: Routes = [
  {path: '', pathMatch: "full", component:LoginComponent},
  {path: 'home', pathMatch: "full", component: HomeComponent},
  {path: 'register', pathMatch: "full", component: RegistrationComponent},
  {path: 'login', pathMatch: "full", component: LoginComponent},
  {path:'upload',pathMatch:"full",component:UploadVideoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
