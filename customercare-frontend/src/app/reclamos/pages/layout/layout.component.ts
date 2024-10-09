import { Component } from '@angular/core';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styles: ``
})
export class LayoutComponent {

  public sidebarItems = [
    { label: 'Consultar Reclamos', icon: 'label', url: './' },
    { label: 'Crear Reclamo', icon: 'add', url: './claims' },
    { label: 'Resumen', icon: 'search', url: './summary' },
  ]

}
