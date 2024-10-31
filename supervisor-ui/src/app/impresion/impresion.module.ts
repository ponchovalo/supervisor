import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ImpresionLayoutComponent } from './layouts/impresion-layout/impresion-layout.component';
import { PrinterListComponent } from './page/printer-list/printer-list.component';
import { Router } from '@angular/router';
import { ImpresionRoutingModule } from './impresion-routing.module';
import { SharedModule } from '../shared/shared.module';



@NgModule({
  declarations: [
    ImpresionLayoutComponent,
    PrinterListComponent
  ],
  imports: [
    CommonModule,
    ImpresionRoutingModule,
    SharedModule
  ]
})
export class ImpresionModule { }
