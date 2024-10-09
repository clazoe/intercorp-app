package com.intercorp.customercare.backend.repositories;

import com.intercorp.customercare.backend.entities.ReclamoEstadoMaestro;
import com.intercorp.customercare.backend.entities.enums.ReclamoEstadoMaestroEnum;
import org.springframework.data.repository.CrudRepository;


import java.util.Optional;

public interface ReclamoEstadoMaestroRepository extends CrudRepository<ReclamoEstadoMaestro, Integer> {
    Optional<ReclamoEstadoMaestro> findByNombreEstado(ReclamoEstadoMaestroEnum reclamoEstadoMaestroEnum);

}
