import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminUsersComponent } from './components/admin_users/admin_users.component';
import { HomeComponent } from './components/home/home.component';
import { UserComponent } from './user/component/user.component';
import { ImageComponent } from './image/component/image.component';
import { AdminCommentsComponent } from './components/admin_comments/admin-comments/admin-comments.component';
import { CommentComponent } from './comment/component/comment/comment.component';
import { AdminRatingsComponent } from './components/admin_ratings/admin-ratings/admin-ratings.component';

const routes: Routes = [
  {
    path: 'admin/users',
    component: AdminUsersComponent,
  },

  {
    path: 'admin/comments',
    component: AdminCommentsComponent,
  },
  {
    path: 'admin/ratings',
    component: AdminRatingsComponent,
  },
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'users/:id',
    component: UserComponent,
  },

  {
    path: 'images/:id',
    component: ImageComponent,
  },
  {
    path: 'comments/:id',
    component: CommentComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
