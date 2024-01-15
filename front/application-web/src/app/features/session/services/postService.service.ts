import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PostRequest } from '../Interfaces/PostRequest';

@Injectable({
  providedIn: 'root',
})
export class PostService {
  constructor(private httpClient: HttpClient) {}
  public createPost(postRequest: PostRequest): Observable<void> {
    return this.httpClient.post<void>(
      'http://localhost:8080/post',
      postRequest
    );
  }
}
