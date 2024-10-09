package com.intercorp.customercare.backend.dto.mapper;

import com.intercorp.customercare.backend.dto.AdjuntoDto;
import com.intercorp.customercare.backend.entities.Adjunto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdjuntoMapper {
    List <Adjunto> toEntity(List<AdjuntoDto> adjuntoDto);
}
