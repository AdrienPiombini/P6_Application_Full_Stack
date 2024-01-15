import { Component } from '@angular/core';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-post',
  templateUrl: './allPostsComponent.component.html',
  styleUrls: ['./allPostsComponent.component.css'],
})
export class AllPostsComponent {
  constructor(private router: Router) {}
  redirectionToOnePost() {
    this.router.navigate(['posts/1']);
  }
}
