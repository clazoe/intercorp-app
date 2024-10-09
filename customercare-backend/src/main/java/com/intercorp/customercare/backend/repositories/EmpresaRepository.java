package com.intercorp.customercare.backend.repositories;

import com.intercorp.customercare.backend.entities.Empresa;
import com.intercorp.customercare.backend.entities.enums.EmpresaEnum;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmpresaRepository  extends CrudRepository<Empresa, Integer> {
    Optional<Empresa> findByNombreEmpresa(EmpresaEnum empresaEnum);
}
