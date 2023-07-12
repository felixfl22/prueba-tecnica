package com.fonyou.pruebatecnica.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class RespuestaDTO {
    private Long id;
    private String respuesta;
    private Long preguntaId;
    private Long estudianteId;
}

