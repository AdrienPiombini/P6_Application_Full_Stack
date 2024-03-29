import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Post } from '../../models/post.models';
import { PostService } from '../../services/postService.service';

@Component({
  selector: 'app-post',
  templateUrl: './allPostsComponent.component.html',
  styleUrls: ['./allPostsComponent.component.css'],
})
export class AllPostsComponent implements OnInit {
  constructor(
    private router: Router,
    private readonly postService: PostService
  ) {}
  posts!: Post[];
  ngOnInit(): void {
    this.postService
      .findAllSubscribePostOfOneUser()
      .subscribe(
        (post: Post[]) =>
          (this.posts = post.sort(
            (a, b) => +new Date(b.created_at) - +new Date(a.created_at)
          ))
      );
  }

  redirectionToOnePost(id: Number) {
    this.router.navigate([`posts/${id}`]);
  }
  redirectionToCreatePost() {
    this.router.navigate(['/posts/create']);
  }
}
