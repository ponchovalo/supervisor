import { Component } from '@angular/core';

@Component({
  selector: 'app-plantillas',
  templateUrl: './plantillas.component.html',
  styleUrl: './plantillas.component.css'
})
export class PlantillasComponent {

  partidas: string[] = ['P-01', 'P-02', 'P-03',
                        'P-04', 'P-05', 'P-06',
                        'P-07', 'P-08', 'P-09',
                        'P-10', 'P-11', 'P-12'];


  dispositivos: string[] = ['SWITCH', 'SERVIDOR', 'TELEFONO']



}
