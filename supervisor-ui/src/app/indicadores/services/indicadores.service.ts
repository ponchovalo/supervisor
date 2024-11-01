import { inject, Injectable } from '@angular/core';
import { environments } from '../../../environments/environments';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Party } from '../interfaces/party.interface';

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
  //? IMPORTAR PLANTILLAS
  importPlantila(formData: FormData): Observable<number>{
  const url = `${this.baseUrl}/plantillas/upload`;
    const body = formData;
    const token: string | null = localStorage.getItem('token');
    const headers = new HttpHeaders()
      .set('Authorization', `Bearer ${token}`.toString());
    //return this.http.post<number>(url, body, {headers});
    return of(69);
  }

  //? CARGAR PARTIDAS
  getParties(): Observable<Party[]>{
    const url = `${this.baseUrl}/plantillas/partidas`;
    const token: string | null = localStorage.getItem('token');
    const headers = new HttpHeaders()
      .set('Authorization', `Bearer ${token}`.toString());

    return this.http.get<Party[]>(url, {headers});
  }
  //? CARGAR DISPOSITIVOS POR PARTIDA
  getDevices(party_number: string): Observable<string[]>{
    const url = `${this.baseUrl}/plantillas/devices`;
    const body = {party_number}
    const token: string | null = localStorage.getItem('token');
    const headers = new HttpHeaders()
      .set('Authorization', `Bearer ${token}`.toString());

    return this.http.post<string[]>(url, body, {headers});
  }


}
