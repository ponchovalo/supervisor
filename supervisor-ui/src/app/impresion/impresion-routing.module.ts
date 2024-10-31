import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ImpresionLayoutComponent } from './layouts/impresion-layout/impresion-layout.component';
import { PrinterListComponent } from './page/printer-list/printer-list.component';
const routes: Routes = [
  {
    path: '',
    component: ImpresionLayoutComponent,
    children: [
      { path: 'list', component: PrinterListComponent },
      { path: '**', redirectTo: 'list' }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ImpresionRoutingModule { }
