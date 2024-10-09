package com.intercorp.customercare.backend.entities;

import com.intercorp.customercare.backend.entities.enums.EmpresaEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "empresa")
@Entity
@Getter
@Setter
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private EmpresaEnum nombreEmpresa;

    @Column(nullable = false)
    private String descripcionEmpresa;
}
