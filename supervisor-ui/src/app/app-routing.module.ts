import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { isAuthenticatedGuard } from './auth/guards/is-authenticated.guard';

const routes: Routes = [
  {
    path: 'auth',
    loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule)
  },
  {
    path: 'indicadores',
    //canActivate: [isAuthenticatedGuard],
    loadChildren: () => import('./indicadores/indicadores.module').then(m => m.IndicadoresModule)
  },
  {
    path: 'impresion',
    loadChildren:() => import('./impresion/impresion.module').then(m => m.ImpresionModule)
  },
  {
    path: '**',
    redirectTo: 'indicadores'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
