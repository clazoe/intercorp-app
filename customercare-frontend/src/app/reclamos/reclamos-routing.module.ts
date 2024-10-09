import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutComponent } from './pages/layout/layout.component';
import { CrearReclamoComponent } from './pages/crear-reclamo/crear-reclamo.component';
import { ConsultarReclamosComponent } from './pages/consultar-reclamos/consultar-reclamos.component';
import { ResumenReclamoComponent } from './pages/resumen-reclamo/resumen-reclamo.component';

const routes: Routes = [{
  path : '',
  component : LayoutComponent,
  children : [  
    {path: '', component: ConsultarReclamosComponent },
    {path: 'claims', component: CrearReclamoComponent },
    {path: 'summary', component: ResumenReclamoComponent }
  ]
}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ReclamosRoutingModule { }
