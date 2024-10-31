import { Component } from '@angular/core';
import { Item } from '../interfaces/item.interface';

@Component({
  selector: 'shared-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css'
})
export class SidebarComponent {

  title: string = 'Indicadores';

  indicadoresItems: Item[] = [
    {
      title: 'Actividades',
      icon: 'pi pi-book mr-4',
      link: '/indicadores/actividades'
    },
    {
      title: 'Preventivos',
      icon: 'pi pi-ticket mr-4',
      link: '/indicadores/preventivos'
    },
    {
      title: 'Plantillas',
      icon: 'pi pi-file mr-4',
      link: '/indicadores/plantillas'
    },
  ]

}
