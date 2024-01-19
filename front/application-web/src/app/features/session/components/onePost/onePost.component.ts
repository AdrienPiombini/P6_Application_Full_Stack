import { Component, OnInit } from '@angular/core';
import { PostService } from '../../services/postService.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Post } from '../../models/post.models';

@Component({
  selector: 'app-onePost',
  templateUrl: './onePost.component.html',
  styleUrls: ['./onePost.component.css'],
})
export class OnePostComponent implements OnInit {
  postId: null | string = '0';
  post!: Post;
  constructor(
    private readonly postService: PostService,
    private readonly route: ActivatedRoute,
    private readonly router: Router
  ) {}

  ngOnInit(): void {
    this.postId = this.route.snapshot.paramMap.get('id');
    if (this.postId != null) {
      this.postService
        .getOnePost(+this.postId)
        .subscribe((post) => (this.post = post));
    }
  }

  redirectionToAllPosts() {
    this.router.navigate([`posts`]);
  }
}
