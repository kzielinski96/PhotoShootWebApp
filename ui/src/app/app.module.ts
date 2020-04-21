import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminUsersComponent } from './components/admin_users/admin_users.component';
import { HomeComponent } from './components/home/home.component';
import { ImageService } from './image/service/image.service';
import { SettingsService } from './services/settings.service';
import { UserComponent } from './user/component/user.component';
import { UserService } from './user/service/user.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { CommentComponent } from './comment/component/comment/comment.component';
import { RatingComponent } from './rating/component/rating/rating.component';
import { ImageComponent } from './image/component/image.component';
import { AdminCommentsComponent } from './components/admin_comments/admin-comments/admin-comments.component';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { AdminRatingsComponent } from './components/admin_ratings/admin-ratings/admin-ratings.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminUsersComponent,
    HomeComponent,
    UserComponent,
    ImageComponent,
    CommentComponent,
    RatingComponent,
    AdminCommentsComponent,
    AdminRatingsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatTableModule,
    MatCardModule,
    MatGridListModule,
    MatFormFieldModule,
    MatSidenavModule,
    MatListModule,
  ],
  providers: [UserService, ImageService, SettingsService],
  bootstrap: [AppComponent],
})
export class AppModule {}
