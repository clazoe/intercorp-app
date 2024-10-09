import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { ReclamosRoutingModule } from './reclamos-routing.module';
import { MaterialModule } from '../material/material.module';

import { ConsultarReclamosComponent } from './pages/consultar-reclamos/consultar-reclamos.component';
import { CrearReclamoComponent } from './pages/crear-reclamo/crear-reclamo.component';
import { ResumenReclamoComponent } from './pages/resumen-reclamo/resumen-reclamo.component';
import { LayoutComponent } from './pages/layout/layout.component';



@NgModule({
  declarations: [
    ConsultarReclamosComponent,
    CrearReclamoComponent,
    ResumenReclamoComponent,
    LayoutComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    ReclamosRoutingModule,
    MaterialModule
  ]
})
export class ReclamosModule { }
