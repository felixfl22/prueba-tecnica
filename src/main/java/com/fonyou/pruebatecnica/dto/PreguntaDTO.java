package com.fonyou.pruebatecnica.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PreguntaDTO {
    private Long id;
    private String textoPregunta;
    private String opcion1;
    private String opcion2;
    private String opcion3;
    private String opcion4;
    private String respuestaCorrecta;
    private Integer puntaje;
}


