package com.intercorp.customercare.backend.repositories;

import com.intercorp.customercare.backend.entities.ReclamoMotivo;
import com.intercorp.customercare.backend.entities.enums.ReclamoMotivoEnum;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ReclamoMotivoRepository extends CrudRepository<ReclamoMotivo, Integer> {
    Optional<ReclamoMotivo> findByNombre(ReclamoMotivoEnum reclamoMotivoEnum);
}
