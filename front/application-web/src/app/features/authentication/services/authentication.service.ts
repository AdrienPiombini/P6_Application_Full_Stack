import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SessionInformation } from 'src/app/interfaces/sessionInformation.interface';
import { LoginRequest } from '../interfaces/LoginRequest';
import { RegisterRequest } from '../interfaces/RegisterRequest';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  constructor(private httpClient: HttpClient) {}
  public login(loginRequest: LoginRequest): Observable<SessionInformation> {
    return this.httpClient.post<SessionInformation>(
      'http://localhost:8080/login',
      loginRequest
    );
  }
  public register(
    registerRequest: RegisterRequest
  ): Observable<SessionInformation> {
    return this.httpClient.post<SessionInformation>(
      'http://localhost:8080/register',
      registerRequest
    );
  }
}
