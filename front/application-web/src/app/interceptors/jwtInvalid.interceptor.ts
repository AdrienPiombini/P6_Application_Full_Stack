import {
  HttpErrorResponse,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SessionService } from '../services/session.service';
import { tap } from 'rxjs';
import { Router } from '@angular/router';

@Injectable()
export class JwtInvalidInterceptor implements HttpInterceptor {
  constructor(private sessionService: SessionService, private router: Router) {}

  public intercept(request: HttpRequest<any>, next: HttpHandler) {
    return next.handle(request).pipe(
      tap(
        () => {},
        (error: any) => {
          if (error instanceof HttpErrorResponse) {
            if (error.status != 401) {
              return;
            }
            this.sessionService.logOut();
            this.router.navigate(['/login']);
          }
        }
      )
    );
  }
}
