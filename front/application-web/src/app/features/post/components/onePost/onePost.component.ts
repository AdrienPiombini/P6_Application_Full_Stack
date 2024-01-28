import { Component, OnInit } from '@angular/core';
import { PostService } from '../../services/postService.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Post } from '../../models/post.models';
import { FormBuilder, Validators } from '@angular/forms';
import { CommentaryRequest } from '../../Interfaces/CommentaryRequest';
import { SessionService } from 'src/app/services/session.service';

@Component({
  selector: 'app-onePost',
  templateUrl: './onePost.component.html',
  styleUrls: ['./onePost.component.css'],
})
export class OnePostComponent implements OnInit {
  postId: null | string = '0';
  post!: Post;
  public onError = false;
  haveCommentary = false;

  constructor(
    private readonly postService: PostService,
    private readonly route: ActivatedRoute,
    private readonly router: Router,
    private readonly formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.postId = this.route.snapshot.paramMap.get('id');
    if (this.postId != null) {
      this.postService.getOnePost(+this.postId).subscribe((post) => {
        if (post.commentaries.length != 0) {
          this.haveCommentary = true;
        }
        this.post = post;
      });
    }
  }

  redirectionToAllPosts() {
    this.router.navigate([`posts`]);
  }

  public form = this.formBuilder.group({
    message: ['', [Validators.required, Validators.max(300)]],
  });
  public submit() {
    const request = this.form.value as unknown as CommentaryRequest;

    if (this.postId != null) {
      this.postService.createCommentary(request, +this.postId).subscribe({
        next: () => {
          this.reloadCurrentRoute();
        },
        error: (error) => {
          this.onError = true;
        },
      });
    }
  }

  private reloadCurrentRoute() {
    const currentUrl = this.router.url;
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
      this.router.navigate([currentUrl]);
    });
  }
}
