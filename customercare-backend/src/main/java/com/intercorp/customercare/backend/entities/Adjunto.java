package com.intercorp.customercare.backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "adjunto")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Adjunto {

    private static final long serialVersionUID = 8495817802073010928L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String nombreAdjunto;

}
