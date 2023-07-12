package com.fonyou.pruebatecnica.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "estudiantes")
@Getter
@Setter
@NoArgsConstructor  // This is important
@AllArgsConstructor
@Builder
public class Estudiantes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private int edad;

    @Column(nullable = false)
    private String ciudad;

    @Column(nullable = false)
    private String zonaHoraria;


    public Estudiantes(Long id) {
        this.id = id;
    }
}
