package com.intercorp.customercare.backend.entities;

import com.intercorp.customercare.backend.entities.enums.ReclamoEstadoMaestroEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "reclamo_estado_maestro")
@Entity
@Getter
@Setter
public class ReclamoEstadoMaestro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private ReclamoEstadoMaestroEnum nombreEstado;

    private String descripcion;
}
