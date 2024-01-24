import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Profile } from '../models/profile.model';
import { Topic } from '../models/topic.models';

@Injectable({
  providedIn: 'root',
})
export class ProfileService {
  constructor(private httpClient: HttpClient) {}

  public getProfile(): Observable<Profile> {
    return this.httpClient.get<Profile>('http://localhost:8080/user');
  }

  public getAllTopicSubsribeAt(): Observable<Topic[]> {
    return this.httpClient.get<Topic[]>('http://localhost:8080/user/topics');
  }

  public save(profile: Profile): Observable<Profile> {
    return this.httpClient.put<Profile>('http://localhost:8080/user', profile);
  }
}
