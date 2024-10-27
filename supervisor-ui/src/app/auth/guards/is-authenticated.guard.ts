import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { AuthStatus } from '../interfaces/auth-status.enum';

export const isAuthenticatedGuard: CanActivateFn = (route, state) => {

  const authService = inject(AuthService);
  const router = inject(Router);

  const url = state.url
  localStorage.setItem('url', url)

  if(authService._authStatus() === AuthStatus.authenticated ) return true;

  if( authService._authStatus() === AuthStatus.cheking) return false;


  router.navigateByUrl('auth/login');

  return false;
};
