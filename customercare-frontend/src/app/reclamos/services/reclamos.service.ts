
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable} from 'rxjs';

import { Reclamo } from '../interfaces/reclamo.interface';
import { environment } from '../../../environments/environment';

@Injectable({ providedIn: 'root' })
export class ReclamosService {
    private baseUrl: string = environment.baseUrl;
    constructor(private http: HttpClient) { }   

   getReclamos():Observable<Reclamo[]> {
        return this.http.get<Reclamo[]>(`${ this.baseUrl }/claims`)
    }

   addReclamo(reclamo : Reclamo) : Observable<Reclamo>{
    return this.http.post<Reclamo>(`${ this.baseUrl }/claims`, reclamo)
   }   
}