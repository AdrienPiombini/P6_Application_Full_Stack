import { NgModule } from '@angular/core';
import { AllPostsComponent } from './components/allPostsComponent/allPostsComponent.component';
import { RouterModule, Routes } from '@angular/router';
import { OnePostComponent } from './components/onePost/onePost.component';
import { CreatePostComponent } from './components/createPost/createPost.component';

const routes: Routes = [
  { path: '', title: 'home', component: AllPostsComponent },
  { path: 'create', title: 'create a post', component: CreatePostComponent },
  { path: ':id', title: 'one post', component: OnePostComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class SessionRoutingModule {}
