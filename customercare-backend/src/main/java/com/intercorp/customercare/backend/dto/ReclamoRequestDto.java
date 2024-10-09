package com.intercorp.customercare.backend.dto;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class ReclamoRequestDto {

    private String descripcion;
    private String reclamoMotivo;
    private String empresa;
    private List<AdjuntoDto> adjuntos;
    private ReclamoEstadoDto reclamoEstado;
    private String correoCliente;

}
