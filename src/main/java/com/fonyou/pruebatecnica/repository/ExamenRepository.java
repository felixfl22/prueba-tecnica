package com.fonyou.pruebatecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fonyou.pruebatecnica.model.Examen;

public interface ExamenRepository extends JpaRepository<Examen, Long> {
}

