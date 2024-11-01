import { inject, Injectable } from '@angular/core';
import { environments } from '../../../environments/environments';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class IndicadoresService {

  baseUrl: string = `${environments.baseUrl}/indicadores`;
  private http = inject(HttpClient);

  token: string | null = '';

  constructor() {
    let tokenLocal = localStorage.getItem('token')
    if(tokenLocal){
      this.token = localStorage.getItem('token');
    }
  }

  testToken(){
    console.log(this.token);
  }

  //! SERVICIOS PARA LAS PLANTILLAS
  //? CARGAR PARTIDAS
  getParties(): Observable<any>{
    const url = `${this.baseUrl}/plantillas/partidas`;
    const token: string | null = localStorage.getItem('token');
    const headers = new HttpHeaders()
      .set('Authorization', `Bearer ${token}`.toString());
      console.log({headers})
    return this.http.get<any>(url, {headers});
  }


}
