package com.intercorp.customercare.backend.entities;

import com.intercorp.customercare.backend.entities.enums.ReclamoMotivoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "reclamo_motivo")
@Entity
@Getter
@Setter
public class ReclamoMotivo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private ReclamoMotivoEnum nombre;

    @Column(nullable = false)
    private String descripcion;
}
