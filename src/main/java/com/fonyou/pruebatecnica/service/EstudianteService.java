package com.fonyou.pruebatecnica.service;

import com.fonyou.pruebatecnica.dto.EstudianteDTO;

import java.util.List;
import java.util.Optional;

public interface EstudianteService {

    List<EstudianteDTO> getAllEstudiantes();

    Optional<EstudianteDTO> getEstudianteById(Long id);

    EstudianteDTO saveEstudiante(EstudianteDTO estudiante);

    void deleteEstudiante(Long id);

}

