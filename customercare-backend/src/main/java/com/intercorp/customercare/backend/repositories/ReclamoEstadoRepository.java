package com.intercorp.customercare.backend.repositories;

import com.intercorp.customercare.backend.entities.ReclamoEstado;
import com.intercorp.customercare.backend.entities.ReclamoEstadoMaestro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface ReclamoEstadoRepository extends CrudRepository<ReclamoEstado, Integer> {
}
