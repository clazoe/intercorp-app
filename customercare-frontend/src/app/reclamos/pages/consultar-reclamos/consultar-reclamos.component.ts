import { Component, OnInit } from '@angular/core';

import { ReclamosService } from '../../services/reclamos.service';


@Component({
  selector: 'app-consultar-reclamos',
  templateUrl: './consultar-reclamos.component.html',
  styleUrls: ['./consultar-reclamos.component.css']
})
export class ConsultarReclamosComponent implements OnInit {

  public reclamos: any[] = [];

  constructor (private reclamoService: ReclamosService){}
   
  ngOnInit(): void  {
    this.getReclamosData();
  }

  public getReclamosData(){
    this.reclamoService.getReclamos()
      .subscribe(reclamos => {
           for (var i in reclamos){
            this.reclamos.push(reclamos[i])
         }
         console.log(reclamos)
      })
    } 
}
