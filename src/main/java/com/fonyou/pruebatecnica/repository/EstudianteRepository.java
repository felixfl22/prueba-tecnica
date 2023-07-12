package com.fonyou.pruebatecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fonyou.pruebatecnica.model.Estudiantes;

public interface EstudianteRepository extends JpaRepository<Estudiantes, Long> {
}
