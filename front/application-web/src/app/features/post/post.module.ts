import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AllPostsComponent } from './components/allPostsComponent/allPostsComponent.component';
import { SessionRoutingModule } from './post-routing.module';
import { OnePostComponent } from './components/onePost/onePost.component';
import { CreatePostComponent } from './components/createPost/createPost.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatOptionModule } from '@angular/material/core';

const materialModules = [
  MatButtonModule,
  MatCardModule,
  MatFormFieldModule,
  MatIconModule,
  MatInputModule,
  MatOptionModule,
];

@NgModule({
  declarations: [AllPostsComponent, OnePostComponent, CreatePostComponent],
  imports: [
    SessionRoutingModule,
    CommonModule,
    ...materialModules,
    FormsModule,
    ReactiveFormsModule,
  ],
})
export class SessionModule {}
