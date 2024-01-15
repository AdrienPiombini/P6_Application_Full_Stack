import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AllPostsComponent } from './components/allPostsComponent/allPostsComponent.component';
import { SessionRoutingModule } from './session-routing.module';
import { OnePostComponent } from './components/one-post/one-post.component';

@NgModule({
  declarations: [AllPostsComponent, OnePostComponent],
  imports: [SessionRoutingModule, CommonModule],
})
export class SessionModule {}
