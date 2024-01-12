import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    // canActivate: [UnauthGuard],
    loadChildren: () =>
      import('./features/authentication/authentication.module').then(
        (m) => m.AuthenticationModule
      ),
  },
  {
    path: 'post',
    loadChildren: () =>
      import('./features/session/session.module').then((m) => m.SessionModule),
  },
  // { path: '404', component: NotFoundComponent },
  // { path: '**', redirectTo: '404' }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
