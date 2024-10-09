import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup,Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { filter, switchMap, tap } from 'rxjs';

import { Reclamo, Empresa } from '../../interfaces/reclamo.interface';
import { ReclamosService } from '../../services/reclamos.service';
import { ValidatorsService } from '../../shared/service/validators.service';

@Component({
  selector: 'app-crear-reclamo',
  templateUrl: './crear-reclamo.component.html',
  styles: ``
})
export class CrearReclamoComponent implements OnInit {

  constructor(
    private heroesService: ReclamosService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private validatorsService: ValidatorsService,
  ) {}

  selectedFile: any = null;


onFileSelected(event: any): void {
    this.selectedFile = event.target.files[0] ?? null;

}



public reclamoForm = new FormGroup({
  descripcion: new FormControl<string>('', { nonNullable: true }),
  reclamoMotivo: new FormControl<string>(''),
  empresa: new FormControl<Empresa>( Empresa.Promart ),
  correoCliente: new FormControl('', [ Validators.required, Validators.pattern( new ValidatorsService().emailPattern )]),

  reclamoEstado: new FormBuilder().group({
    correoAsesor: new FormControl<string>('', [ Validators.required, Validators.pattern( new ValidatorsService().emailPattern )]), 
    comentarioAsesor: new FormControl('', { nonNullable: true } ),
    estado: new FormControl<string>(''),
  })
});

isValidField( field: string ) {
  return this.validatorsService.isValidField( this.reclamoForm, field );
}

isChildValidField( field: string ) {
  return this.validatorsService.isChildValidField( this.reclamoForm, field );
}





public empresas = [
  { id: 'Promart', desc: 'Promart' },
  { id: 'Oeschle', desc: 'Oeschle' },
  { id: 'plazaVea', desc: 'plazaVea' },
  { id: 'Vivanda', desc: 'Vivanda' },
];

public reclamoMotivo = [
  { id: 'FECHA_ENTREGA_INCUMPLIDA', desc: 'Fecha de Entrega Incumplida' },
  { id: 'PROBLEMAS_CON_PERSONAL', desc: 'Producto con Defectos' },
  { id: 'PRODUCTO_CON_DEFECTOS', desc: 'Problemas con Personal' },
];

public estados = [
  { id: 'EN_REVISION', desc: 'En revisión' },
  { id: 'CERRADA', desc: 'Cerrada' },
  { id: 'ANULADA', desc: 'Anulada' },
];



get currentReclamo(): Reclamo {
  const hero = this.reclamoForm.value as Reclamo;
  return hero;
}

  ngOnInit(): void {
  
  }


  onSubmit():void {

    console.log("submit")

    if ( this.reclamoForm.invalid ) return;

    this.heroesService.addReclamo( this.currentReclamo )
    .subscribe( hero => {
      // TODO: mostrar snackbar, y navegar a /heroes/edit/ hero.id
      //this.router.navigate(['/heroes/edit', hero.id ]);
      //this.showSnackbar(`${ hero.superhero } created!`);
      console.log(hero)
      this.router.navigate(['/']);
    });
   
  }

}
