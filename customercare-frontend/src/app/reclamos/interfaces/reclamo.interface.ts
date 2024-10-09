import { ReclamoEstado } from '../interfaces/reclamoestado.interfaces';
import { Adjunto } from '../interfaces/adjunto.interfaces';

export interface Reclamo {
  descripcion:   string;
  reclamoMotivo: ReclamoMotivo;
  empresa:       Empresa;
  correoCliente: string;
  adjuntos:      Adjunto[];
  reclamoEstado: ReclamoEstado;
}


export enum Empresa {
  Promart = "Promart",
  Oeschle = "Oeschle",
  plazaVea = "plazaVea",
  Vivanda = "Vivanda"
}


export enum ReclamoMotivo {
  FechaIncumplida = "Fecha de Entrega Incumplida",
  ProblemasPersonal = "Problemas con Personal",
  ProductosDefecto = "Producto con Defectos",
}