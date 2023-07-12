package com.fonyou.pruebatecnica.service.impl;

import com.fonyou.pruebatecnica.dto.ExamenDTO;
import com.fonyou.pruebatecnica.dto.PreguntaDTO;
import com.fonyou.pruebatecnica.model.Estudiantes;
import com.fonyou.pruebatecnica.model.Examen;
import com.fonyou.pruebatecnica.model.Pregunta;
import com.fonyou.pruebatecnica.repository.ExamenRepository;
import com.fonyou.pruebatecnica.service.ExamenService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExamenServiceImpl implements ExamenService {

    private final ExamenRepository examenRepository;

    public ExamenServiceImpl(ExamenRepository examenRepository) {
        this.examenRepository = examenRepository;
    }
    @Override
    public List<ExamenDTO> getAllExamenes() {
        List<Examen> examen =examenRepository.findAll();

        return examen.stream().map(examen1 -> ExamenDTO.builder()
                .id(examen1.getId())
                .preguntas(examen1.getPreguntas().stream().map(pregunta -> PreguntaDTO.builder()
                        .id(pregunta.getId())
                        .opcion1(pregunta.getOpcionA())
                        .opcion2(pregunta.getOpcionB())
                        .opcion3(pregunta.getOpcionC())
                        .opcion4(pregunta.getOpcionD()).build()).collect(Collectors.toList())).build()).collect(Collectors.toList());
    }

    @Override
    public Optional<ExamenDTO> getExamenById(Long id) {
        Optional<Examen> examen = examenRepository.findById(id);
        return examen.map(examen1 -> ExamenDTO.builder()
                .id(examen1.getId())
                .preguntas(examen1.getPreguntas().stream().map(pregunta -> PreguntaDTO.builder()
                        .id(pregunta.getId())
                        .opcion1(pregunta.getOpcionA())
                        .opcion2(pregunta.getOpcionB())
                        .opcion3(pregunta.getOpcionC())
                        .opcion4(pregunta.getOpcionD()).build()).collect(Collectors.toList())).build());
    }

    @Override
    public ExamenDTO saveExamen(ExamenDTO examenDTO) {
        // Aquí mapeamos el DTO a la entidad
        Examen examen = Examen.builder()
                .id(examenDTO.getId())
                .fechaExamen(examenDTO.getFechaExamen())
                .estudiante(new Estudiantes(examenDTO.getEstudianteId())) // asumimos que tienes un constructor en Estudiante que acepta un id
                .build();

        // Aquí mapeamos las Preguntas del DTO a las entidades, vinculándolas con el Examen
        List<Pregunta> preguntas = examenDTO.getPreguntas().stream()
                .map(preguntaDTO -> Pregunta.builder()
                        .id(preguntaDTO.getId())
                        .textoPregunta(preguntaDTO.getTextoPregunta())
                        .opcionA(preguntaDTO.getOpcion1())
                        .opcionB(preguntaDTO.getOpcion2())
                        .opcionC(preguntaDTO.getOpcion3())
                        .opcionD(preguntaDTO.getOpcion4())
                        .respuestaCorrecta(preguntaDTO.getRespuestaCorrecta())
                        .puntuacion(preguntaDTO.getPuntaje())
                        .examen(examen) // vinculamos la pregunta con el examen
                        .build())
                .collect(Collectors.toList());

        examen.setPreguntas(preguntas); // asociamos las preguntas al examen

        // Aquí guardamos el Examen y las Preguntas en la base de datos
        Examen examenGuardado = examenRepository.save(examen);



        return ExamenDTO.builder()
                .id(examenGuardado.getId())
                .fechaExamen(examenGuardado.getFechaExamen())
                .estudianteId(examenGuardado.getEstudiante().getId())
                .preguntas(examenGuardado.getPreguntas().stream()
                        .map(pregunta -> PreguntaDTO.builder()
                                .id(pregunta.getId())
                                .textoPregunta(pregunta.getTextoPregunta())
                                .opcion1(pregunta.getOpcionA())
                                .opcion2(pregunta.getOpcionB())
                                .opcion3(pregunta.getOpcionC())
                                .opcion4(pregunta.getOpcionD())
                                .respuestaCorrecta(pregunta.getRespuestaCorrecta())
                                .puntaje(pregunta.getPuntuacion())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }


    @Override
    public void deleteExamen(Long id) {
        examenRepository.deleteById(id);
    }
}
