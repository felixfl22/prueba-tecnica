package com.fonyou.pruebatecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fonyou.pruebatecnica.model.Pregunta;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
    // Aquí puedes definir métodos de búsqueda personalizados si los necesitas
}

