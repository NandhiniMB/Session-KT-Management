import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import {MenuComponent, NotificationDialog} from './menu/menu.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

// import {MatPaginator} from '@angular/material/paginator';
// import {MatTableDataSource} from '@angular/material/table';

import { HttpClientModule } from '@angular/common/http';
import { LoginSuccessComponent } from './login-success/login-success.component';
import { HomeComponent } from './home/home.component';
import { UploadVideoComponent } from './upload-video/upload-video.component';
import { MainComponent } from './main/main.component';
import { ManageVideoComponent } from './manage-video/manage-video.component';
import { VideoStatusComponent } from './video-status/video-status.component';
import { ReportedVideosComponent } from './reported-videos/reported-videos.component';
import { CategoryComponent } from './category/category.component';
import { PlayVideoComponent } from './play-video/play-video.component';
import {MatRadioModule} from '@angular/material/radio';
import {MatTableModule} from '@angular/material/table';
import {MatButtonModule} from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import {MatInputModule} from '@angular/material/input';
import { MatIconModule} from '@angular/material/icon';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import {MatBadgeModule} from '@angular/material/badge';
import { MatSelectModule } from '@angular/material/select';
import {MatTabsModule} from '@angular/material/tabs';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatDialogModule} from '@angular/material/dialog';
import {MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list';
import { MatExpansionModule } from '@angular/material//expansion';
//import { FlexLayoutModule } from '@angular/flex-layout';
import {MatButtonToggleModule} from '@angular/material/button-toggle';

// import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';



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
    CategoryComponent,
    PlayVideoComponent,
    NotificationDialog
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
    MatTabsModule,
    MatTableModule,
    MatCheckboxModule,
    MatDialogModule,
    MatCardModule,
    MatGridListModule,
    MatExpansionModule,
    MatPaginatorModule,
    MatButtonToggleModule,
    MatRadioModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  // exports: [MatButtonModule,
  //           MatToolbarModule]
})
export class AppModule { }
