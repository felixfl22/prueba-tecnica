package com.fonyou.pruebatecnica.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Setter
@Getter
public class EstudianteDTO {

    private Long id;
    private String nombre;
    private int edad;
    private String ciudad;
    private String zonaHoraria;


}

