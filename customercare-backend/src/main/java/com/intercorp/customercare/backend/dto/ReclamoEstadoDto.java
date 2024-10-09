package com.intercorp.customercare.backend.dto;

import lombok.Data;

@Data
public class ReclamoEstadoDto {
    private String correoCliente;
    private String estado;
    private String comentarioAsesor;
    private String correoAsesor;
}
