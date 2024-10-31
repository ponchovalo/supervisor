import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { IndicadoresRoutingModule } from './indicadores-routing.module';
import { IndicaLayoutComponent } from './layouts/indica-layout/indica-layout.component';
import { ActividadesComponent } from './pages/actividades/actividades.component';
import { SharedModule } from '../shared/shared.module';
import { PreventivosComponent } from './pages/preventivos/preventivos.component';
import { PlantillasComponent } from './pages/plantillas/plantillas.component';
import { PrimengModule } from '../primeng/primeng.module';


@NgModule({
  declarations: [
    IndicaLayoutComponent,
    ActividadesComponent,
    PreventivosComponent,
    PlantillasComponent
  ],
  imports: [
    CommonModule,
    IndicadoresRoutingModule,
    SharedModule,
    PrimengModule
  ]
})
export class IndicadoresModule { }
