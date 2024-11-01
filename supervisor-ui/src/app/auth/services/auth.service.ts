import { computed, inject, Injectable, signal } from '@angular/core';
import { environments } from '../../../environments/environments';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, Observable, of, tap, throwError } from 'rxjs';
import { User } from '../interfaces/user.interface';
import { AuthStatus } from '../interfaces/auth-status.enum';
import { LoginResponse } from '../interfaces/login-response.interface';
import { JwtHelperService } from '@auth0/angular-jwt';

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
  public _authStatus = signal<AuthStatus>(AuthStatus.cheking);

  constructor(){
    this.checkAuthStatus().subscribe();
  }


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
        }),
        map(() => true),
        catchError(err => throwError(() => err.error))
      )
  }

  checkAuthStatus(): Observable<boolean>{

    const url = `${this.baseUrl}/identity/auth/check-token`
    const token = localStorage.getItem('token');

    if(!token){
      this._authStatus.set(AuthStatus.notAuthenticated);
      return of(false);
    }
    const jwtHelper = new JwtHelperService();
    const isTokenExpired = jwtHelper.isTokenExpired(token);

    if(isTokenExpired){
      localStorage.clear();
      return of(false);;
    }

    const headers = new HttpHeaders()
      .set('Authorization', `Bearer ${ token }`);
      console.log({headers})

    return this.http.get<LoginResponse>(url, {headers})
      .pipe(
        tap(({user, token}) => {
          this._currentUser.set(user);
          this._authStatus.set(AuthStatus.authenticated);
          localStorage.setItem('token', token);
        }),
        map(() => true),
        catchError(() => {
          this._authStatus.set(AuthStatus.notAuthenticated);
          return of(false)
        })
      )
  }


}
