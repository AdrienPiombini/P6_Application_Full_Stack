import { Component } from '@angular/core';
import { FormBuilder, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SessionInformation } from 'src/app/interfaces/sessionInformation.interface';
import { SessionService } from 'src/app/services/session.service';
import { AuthenticationService } from '../../services/authentication.service';
import { LoginRequest } from '../../interfaces/LoginRequest';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  constructor(
    private sessionService: SessionService,
    private router: Router,
    private authenticationService: AuthenticationService,
    private formBuilder: FormBuilder
  ) {}

  public hide = true;
  public onError = false;

  public form = this.formBuilder.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.min(3)]],
  });

  public submit(): void {
    const loginRequest = this.form.value as LoginRequest;
    this.authenticationService
      .login(
        loginRequest
        // {email: 'test@test.com',
        // password: 'test!31',}
      )
      .subscribe({
        next: (response: any) => {
          this.sessionService.logIn(response);
          this.router.navigate(['/posts']);
        },
        error: (error) => (this.onError = true),
      });
  }
}
