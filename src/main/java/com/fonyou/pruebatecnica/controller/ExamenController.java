package com.fonyou.pruebatecnica.controller;


import com.fonyou.pruebatecnica.dto.ExamenDTO;
import com.fonyou.pruebatecnica.service.ExamenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/examen")
public class ExamenController {

    private final ExamenService examenService;

    public ExamenController(ExamenService examenService) {
        this.examenService = examenService;
    }

    @GetMapping
    public ResponseEntity<List<ExamenDTO>> getAllExamenes() {
        return new ResponseEntity<>(examenService.getAllExamenes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ExamenDTO>> getExamenById(@PathVariable Long id) {
        return new ResponseEntity<>(examenService.getExamenById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ExamenDTO> saveExamen(@RequestBody ExamenDTO examen) {
        return new ResponseEntity<>(examenService.saveExamen(examen), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExamen(@PathVariable Long id) {
        examenService.deleteExamen(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
