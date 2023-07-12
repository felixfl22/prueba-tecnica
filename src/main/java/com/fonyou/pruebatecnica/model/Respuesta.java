package com.fonyou.pruebatecnica.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Respuestas")
@Getter
@Setter
@NoArgsConstructor
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Respuesta")
    private Long id;

    @Column(name = "Respuesta", nullable = false)
    private String respuesta;

    @ManyToOne
    @JoinColumn(name="ID_Pregunta", nullable=false)
    private Pregunta pregunta;

    @ManyToOne
    @JoinColumn(name="ID_Estudiante", nullable=false)
    private Estudiantes estudiante;
}

