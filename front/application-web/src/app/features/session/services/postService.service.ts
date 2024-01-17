import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PostRequest } from '../Interfaces/PostRequest';
import { Post } from '../models/post.models';

@Injectable({
  providedIn: 'root',
})
export class PostService {
  constructor(private httpClient: HttpClient) {}
  public createPost(postRequest: PostRequest): Observable<any> {
    return this.httpClient.post<any>('http://localhost:8080/post', postRequest);
  }

  public findAllSubscribePostOfOneUser(): Observable<Post[]> {
    return this.httpClient.get<Post[]>('http://localhost:8080/post');
  }
  public getOnePost(id: number) {
    return this.httpClient.get<Post>(`http://localhost:8080/post/${id}`);
  }
}
