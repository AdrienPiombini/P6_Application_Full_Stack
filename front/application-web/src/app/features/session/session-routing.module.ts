import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AllPostsComponent } from './components/allPostsComponent/allPostsComponent.component';
import { RouterModule, Routes } from '@angular/router';
import { OnePostComponent } from './components/one-post/one-post.component';

const routes: Routes = [
  { path: '', title: 'home', component: AllPostsComponent },
  { path: '1', title: 'one post', component: OnePostComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class SessionRoutingModule {}
