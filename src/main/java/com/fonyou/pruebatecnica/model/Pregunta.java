package com.fonyou.pruebatecnica.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Preguntas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Pregunta")
    private Long id;

    @Column(name = "Pregunta_Texto", nullable = false)
    private String textoPregunta;

    @Column(name = "Opcion_A", nullable = false)
    private String opcionA;

    @Column(name = "Opcion_B", nullable = false)
    private String opcionB;

    @Column(name = "Opcion_C", nullable = false)
    private String opcionC;

    @Column(name = "Opcion_D", nullable = false)
    private String opcionD;

    @Column(name = "Respuesta_Correcta", nullable = false)
    private String respuestaCorrecta;

    @Column(name = "Puntaje", nullable = false)
    private Integer puntuacion;

    @ManyToOne
    @JoinColumn(name="ID_Examen", nullable=false)
    private Examen examen;

    @OneToMany(mappedBy = "pregunta")
    private List<Respuesta> respuestas;
}

