import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { SessionInformation } from 'src/app/interfaces/sessionInformation.interface';
import { SessionService } from 'src/app/services/session.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  constructor(private sessionService: SessionService, private router: Router) {}
  public submit(): void {
    const user: SessionInformation = {
      admin: false,
      token: 'jwt',
      username: 'test',
      email: 'test@test.com',
    };
    this.sessionService.logIn(user);
    this.router.navigate(['/post']);
  }
}
