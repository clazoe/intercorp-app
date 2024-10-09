package com.intercorp.customercare.backend.dto.mapper;

import com.intercorp.customercare.backend.dto.ReclamoResponseDto;
import com.intercorp.customercare.backend.entities.Reclamo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReclamoResponseMapper {
    ReclamoResponseDto toDto(Reclamo reclamo);
}
