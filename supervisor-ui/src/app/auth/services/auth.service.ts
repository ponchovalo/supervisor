import { computed, inject, Injectable, signal } from '@angular/core';
import { environments } from '../../../environments/environments';
import { HttpClient } from '@angular/common/http';
import { catchError, map, Observable, of, tap, throwError } from 'rxjs';
import { User } from '../interfaces/user.interface';
import { AuthStatus } from '../interfaces/auth-status.enum';
import { LoginResponse } from '../interfaces/login-response.interface';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  //! Mundo interior del servicio
  private readonly baseUrl: string = environments.baseUrl;
  private http = inject(HttpClient);

  //! Manejo del usuario mediante signals
  private _currentUser = signal<User|null>(null);

  //! Estado de la autenticacion mediante signals
  private _authStatus = signal<AuthStatus>(AuthStatus.cheking);


  //! Mundo exterior del servicio
  public currentUser = computed(()=>this._currentUser);
  public authStatus = computed(()=>this._authStatus);


  login(username: string, password: string): Observable<boolean>{

    const url = `${this.baseUrl}/identity/auth/authenticate`;
    const body = {username, password};

    return this.http.post<LoginResponse>(url, body)
      .pipe(
        tap(({user, token}) => {
          this._currentUser.set(user);
          this._authStatus.set(AuthStatus.authenticated);
          localStorage.setItem('token', token);
          console.log({user, token})
        }),
        map(() => true),
        catchError(err => throwError(() => err.error))
      )
  }

}
