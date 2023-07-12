package com.fonyou.pruebatecnica.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExamenDTO {
    private Long id;
    private LocalDateTime fechaExamen;
    private Long estudianteId;  // Id del estudiante asociado con el examen
    private List<PreguntaDTO> preguntas;
}
