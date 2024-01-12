import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PostComponent } from './components/post/post.component';
import { SessionRoutingModule } from './session-routing.module';

@NgModule({
  declarations: [PostComponent],
  imports: [SessionRoutingModule, CommonModule],
})
export class SessionModule {}
