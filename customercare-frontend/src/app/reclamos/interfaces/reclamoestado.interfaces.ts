export interface ReclamoEstado {
    correoAsesor:     string;
    comentarioAsesor: string;
    estado:           Estado;
}

export enum Estado {
    Pendiente = "Pendiente",
    Revision = "En revisión",
    Cerrada = "Cerrada",
    Anulada = "Anulada"
  }