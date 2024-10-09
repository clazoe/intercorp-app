package com.intercorp.customercare.backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Table(name = "reclamo_estado")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ReclamoEstado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @ManyToOne
    private ReclamoEstadoMaestro reclamoEstadoMaestro;

    @Column(length = 150, nullable = false)
    private String comentarioAsesor;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private Date updatedAt;

    @Column(length = 50, nullable = false)
    private String correoAsesor;

    @JoinColumn(name = "id")
    @OneToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Reclamo reclamo;

}
