package com.fonyou.pruebatecnica.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Examenes")
@Getter
@Setter
@NoArgsConstructor  // This is important
@AllArgsConstructor
@Builder
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Examen")
    private Long id;

    @Column(name = "Fecha_Examen", nullable = false)
    private LocalDateTime fechaExamen;

    @Column(name = "Puntuacion_Total")
    private Integer puntuacionTotal;

    @ManyToOne
    @JoinColumn(name="ID_Estudiante", nullable=false)
    private Estudiantes estudiante;

    @OneToMany(mappedBy = "examen")
    private List<Pregunta> preguntas;
}

