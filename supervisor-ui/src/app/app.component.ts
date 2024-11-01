import { Component, computed, effect, inject } from '@angular/core';
import { AuthService } from './auth/services/auth.service';
import { AuthStatus } from './auth/interfaces/auth-status.enum';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'supervisor-ui';

  private authService = inject(AuthService);
  private router = inject(Router);

  public finishedAuthCheck = computed<boolean>(() => {
    if(this.authService._authStatus() === AuthStatus.cheking){
      return false;
    }

    return true;

  });

  public authStatusChangeEffect = effect(() => {
    switch( this.authService._authStatus() ) {

      case AuthStatus.cheking:
        return;

      case AuthStatus.authenticated:
        const url = localStorage.getItem('url');
        if(url){
          this.router.navigateByUrl(url);
        }
        this.router.navigateByUrl('/indicadores')

        return;

      case AuthStatus.notAuthenticated:
        this.router.navigateByUrl('/auth/login');
        return;
    }
  });

}
