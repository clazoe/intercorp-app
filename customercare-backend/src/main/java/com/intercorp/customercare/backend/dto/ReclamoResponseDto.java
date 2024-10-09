package com.intercorp.customercare.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.intercorp.customercare.backend.entities.Reclamo;
import lombok.Data;

@Data
public class ReclamoResponseDto {

    //@JsonProperty("reclamo")
    private Reclamo reclamo;
}
