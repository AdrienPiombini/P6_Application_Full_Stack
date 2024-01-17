import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Topic } from '../models/topic.models';

@Injectable({
  providedIn: 'root',
})
export class TopicService {
  constructor(private httpClient: HttpClient) {}

  public getAllTopics(): Observable<Topic[]> {
    return this.httpClient.get<Topic[]>('http://localhost:8080/topics');
  }

  public subscribeToTopic(topic: Topic): Observable<void> {
    return this.httpClient.post<void>('http://localhost:8080/topics', topic);
  }
}
