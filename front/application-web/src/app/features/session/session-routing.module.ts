import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AllPostsComponent } from './components/allPostsComponent/allPostsComponent.component';
import { RouterModule, Routes } from '@angular/router';
import { OnePostComponent } from './components/onePost/onePost.component';
import { CreatePostComponent } from './components/createPost/createPost.component';

const routes: Routes = [
  { path: '', title: 'home', component: AllPostsComponent },
  { path: '1', title: 'one post', component: OnePostComponent },
  { path: 'create', title: 'create a post', component: CreatePostComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class SessionRoutingModule {}
