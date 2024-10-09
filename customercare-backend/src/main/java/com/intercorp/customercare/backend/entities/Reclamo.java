package com.intercorp.customercare.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Table(name = "reclamo")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Reclamo implements Serializable {

    private static final long serialVersionUID = -748956247024967638L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String descripcion;

    @ManyToOne
    private ReclamoMotivo reclamoMotivo;

    @ManyToOne
    private Empresa empresa;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "reclamo_id")
    @JsonManagedReference
    private List<Adjunto> adjuntos;

    @CreationTimestamp
    @Column(updatable = false, name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(length = 50, nullable = false)
    private String correoCliente;

    @OneToOne(mappedBy = "reclamo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private ReclamoEstado reclamoEstado;


}
