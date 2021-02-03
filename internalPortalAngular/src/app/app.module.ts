import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import {MenuComponent} from './menu/menu.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import {MatButtonModule} from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import {MatInputModule} from '@angular/material/input';
import { HttpClientModule } from '@angular/common/http';
import { LoginSuccessComponent } from './login-success/login-success.component';
import { HomeComponent } from './home/home.component';
import { UploadVideoComponent } from './upload-video/upload-video.component';
import { MatIconModule} from '@angular/material/icon';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import {MatBadgeModule} from '@angular/material/badge';
import { MatSelectModule } from '@angular/material/select';
import { MainComponent } from './main/main.component';
import { ManageVideoComponent } from './manage-video/manage-video.component';
import {MatTabsModule} from '@angular/material/tabs';
import { VideoStatusComponent } from './video-status/video-status.component';
import { ReportedVideosComponent } from './reported-videos/reported-videos.component';
import { CategoryComponent } from './category/category.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    LoginSuccessComponent,
    HomeComponent,
    UploadVideoComponent,
    MenuComponent,
    MainComponent,
    ManageVideoComponent,
    VideoStatusComponent,
    ReportedVideosComponent,
    CategoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatButtonModule,
    MatToolbarModule,
    MatInputModule,
    MatIconModule,
    MatSidenavModule,
    MatListModule,
    MatBadgeModule,
    MatSelectModule,
    MatTabsModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  // exports: [MatButtonModule,
  //           MatToolbarModule]
})
export class AppModule { }
