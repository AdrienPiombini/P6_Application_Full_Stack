import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SessionService } from 'src/app/services/session.service';
import { LoginRequest } from '../../interfaces/LoginRequest';
import { AuthenticationService } from '../../services/authentication.service';
import { RegisterRequest } from '../../interfaces/RegisterRequest';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {
  constructor(
    private sessionService: SessionService,
    private router: Router,
    private authenticationService: AuthenticationService,
    private formBuilder: FormBuilder
  ) {}
  public onError = false;
  passwordRegex: RegExp =
    /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+{}\[\]:;<>,.?~\\/-]).{8,}$/;

  public form = this.formBuilder.group({
    email: ['', [Validators.required, Validators.email]],
    username: [
      '',
      [Validators.required, Validators.min(3), Validators.max(20)],
    ],
    password: [
      '',
      [
        Validators.required,
        Validators.min(8),
        Validators.pattern(this.passwordRegex),
      ],
    ],
  });

  public submit(): void {
    const registerRequest = this.form.value as RegisterRequest;
    this.authenticationService.register(registerRequest).subscribe({
      next: (response: any) => {
        this.sessionService.logIn(response);
        this.router.navigate(['/posts']);
      },
      error: (error) => (this.onError = true),
    });
  }
}
