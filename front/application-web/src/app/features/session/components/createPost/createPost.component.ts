import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SessionService } from 'src/app/services/session.service';
import { PostRequest } from '../../Interfaces/PostRequest';
import { PostService } from '../../services/postService.service';

@Component({
  selector: 'app-create-post',
  templateUrl: './createPost.component.html',
  styleUrls: ['./createPost.component.css'],
})
export class CreatePostComponent {
  constructor(
    private postService: PostService,
    private router: Router,
    private formBuilder: FormBuilder
  ) {}

  public onError = false;

  public form = this.formBuilder.group({
    title: ['', [Validators.required, Validators.min(3)]],
    content: ['', [Validators.required, Validators.max(300)]],
    topic: ['', [Validators.required]],
  });
  public submit() {
    const request = this.form.value as unknown as PostRequest;
    this.postService.createPost(request).subscribe({
      next: () => {
        this.router.navigate(['/posts']);
      },
      error: (error) => (this.onError = true),
    });
  }
}
