import { Component, inject, OnInit } from '@angular/core';
import { IndicadoresService } from '../../services/indicadores.service';
import { Party } from '../../interfaces/party.interface';

@Component({
  selector: 'app-plantillas',
  templateUrl: './plantillas.component.html',
  styleUrl: './plantillas.component.css'
})
export class PlantillasComponent implements OnInit {

  // Variables importar plantillas
  visibleImportDialog: boolean = false;
  fileName: string = '';
  formData = new FormData();

  // Variables para filtro
  selectedParty: string = '';
  selectedDevice: string = '';

  parties: Party[] = [];

  devices: string[] = [];

  private indicadoresService = inject(IndicadoresService)

  ngOnInit(): void {
    this.loadAndPrintData();
  }
  // Inizializacion de datos
  loadAndPrintData(){
    this.getParties();
  }
  getParties(){
    this.indicadoresService.getParties().subscribe(parties => {
      this.parties = parties;
    });
  }
  getDevices(party: string){
    this.indicadoresService.getDevices(party).subscribe(devices => {
      this.devices = devices;
    })
  }

  // Filtrar Plantillas
  onSelectParty(party:string){
    this.selectedParty = party;
    this.getDevices(party);
    //! TODO metodo para filtrar plantillas por partida
  }
  onSelectDevice(device: string){
    this.selectedDevice = device;
  }


  // Importar Archivo de plantillas
  showImportDialog(){
    this.visibleImportDialog = true;
  }
  closeImportDialog(){
    this.visibleImportDialog = false;
    this.formData.delete('file');
    this.fileName = '';
  }
  onFileSelected(event:any){
    const file: File = event.target.files[0];
    if(file){
      this.fileName = file.name;
      this.formData.append('file', file);
    }
  }
  uploadPlantilla(){
    this.indicadoresService.importPlantila(this.formData).subscribe(data => {
      console.log(data);
      this.closeImportDialog()
    })
  }





}
