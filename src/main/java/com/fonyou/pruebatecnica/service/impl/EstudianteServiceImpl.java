package com.fonyou.pruebatecnica.service.impl;

import com.fonyou.pruebatecnica.dto.EstudianteDTO;
import com.fonyou.pruebatecnica.model.Estudiantes;
import com.fonyou.pruebatecnica.repository.EstudianteRepository;
import com.fonyou.pruebatecnica.service.EstudianteService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteServiceImpl(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public List<EstudianteDTO> getAllEstudiantes() {
        List<Estudiantes> estudiantes = estudianteRepository.findAll();
        return estudiantes.stream()
                .map(estudiante -> EstudianteDTO.builder()
                        .id(estudiante.getId())
                        .nombre(estudiante.getNombre())
                        .edad(estudiante.getEdad())
                        .ciudad(estudiante.getCiudad())
                        .zonaHoraria(estudiante.getZonaHoraria())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EstudianteDTO> getEstudianteById(Long id) {
        Optional<Estudiantes> estudiante = estudianteRepository.findById(id);
        return estudiante.map(
                estudiante1 -> EstudianteDTO.builder()
                        .id(estudiante1.getId())
                        .nombre(estudiante1.getNombre())
                        .edad(estudiante1.getEdad())
                        .ciudad(estudiante1.getCiudad())
                        .zonaHoraria(estudiante1.getZonaHoraria())
                        .build());
    }

    @Override
    public EstudianteDTO saveEstudiante(EstudianteDTO estudianteDto) {
        Estudiantes estudiante = Estudiantes.builder()
                .id(estudianteDto.getId())
                .nombre(estudianteDto.getNombre())
                .edad(estudianteDto.getEdad())
                .ciudad(estudianteDto.getCiudad())
                .zonaHoraria(estudianteDto.getZonaHoraria())
                .build();

        Estudiantes estudianteGuardado = estudianteRepository.save(estudiante);

        return EstudianteDTO.builder()
                .id(estudianteGuardado.getId())
                .nombre(estudianteGuardado.getNombre())
                .edad(estudianteGuardado.getEdad())
                .ciudad(estudianteGuardado.getCiudad())
                .zonaHoraria(estudianteGuardado.getZonaHoraria())
                .build();
    }


    @Override
    public void deleteEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }
}

