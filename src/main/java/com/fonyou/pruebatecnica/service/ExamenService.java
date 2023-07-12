package com.fonyou.pruebatecnica.service;

import com.fonyou.pruebatecnica.dto.ExamenDTO;
import com.fonyou.pruebatecnica.model.Examen;
import java.util.List;
import java.util.Optional;

public interface ExamenService {

    List<ExamenDTO> getAllExamenes();

    Optional<ExamenDTO> getExamenById(Long id);

    ExamenDTO saveExamen(ExamenDTO examen);

    void deleteExamen(Long id);

}

