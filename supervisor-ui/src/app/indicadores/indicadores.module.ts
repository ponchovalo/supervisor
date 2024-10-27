import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { IndicadoresRoutingModule } from './indicadores-routing.module';
import { IndicaLayoutComponent } from './layouts/indica-layout/indica-layout.component';
import { ActividadesComponent } from './pages/actividades/actividades.component';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [
    IndicaLayoutComponent,
    ActividadesComponent
  ],
  imports: [
    CommonModule,
    IndicadoresRoutingModule,
    SharedModule
  ]
})
export class IndicadoresModule { }
