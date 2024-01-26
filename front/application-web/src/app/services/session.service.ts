import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { SessionInformation } from '../interfaces/sessionInformation.interface';
import { Router } from '@angular/router';
const LOCAL_STORAGE_USER_KEY = 'mddUser';
@Injectable({
  providedIn: 'root',
})
export class SessionService {
  constructor() {
    const user = this.getStoredUser();
    if (user) {
      this.sessionInformation = user;
      this.isLogged = true;
      this.next();
    }
  }

  public isLogged = false;
  public sessionInformation: SessionInformation | undefined;

  private isLoggedSubject = new BehaviorSubject<boolean>(this.isLogged);

  public $isLogged(): Observable<boolean> {
    return this.isLoggedSubject.asObservable();
  }

  public logIn(user: SessionInformation): void {
    this.storeUser(user);
    this.sessionInformation = user;
    this.isLogged = true;
    this.next();
  }

  public logOut(): void {
    this.deleteStoredUser();
    this.sessionInformation = undefined;
    this.isLogged = false;
    this.next();
  }

  private next(): void {
    this.isLoggedSubject.next(this.isLogged);
  }

  private storeUser(user: SessionInformation): void {
    window.localStorage.setItem(LOCAL_STORAGE_USER_KEY, JSON.stringify(user));
  }
  private deleteStoredUser(): void {
    window.localStorage.removeItem(LOCAL_STORAGE_USER_KEY);
  }

  private getStoredUser(): SessionInformation | null {
    const storedUserString = window.localStorage.getItem(
      LOCAL_STORAGE_USER_KEY
    );
    if (storedUserString) {
      return JSON.parse(storedUserString);
    }
    return null;
  }
}
