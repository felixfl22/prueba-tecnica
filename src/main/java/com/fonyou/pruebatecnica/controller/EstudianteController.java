package com.fonyou.pruebatecnica.controller;

import com.fonyou.pruebatecnica.dto.EstudianteDTO;
import com.fonyou.pruebatecnica.service.EstudianteService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los estudiantes")
    public ResponseEntity<List<EstudianteDTO>> getAllEstudiantes() {
        return ResponseEntity.ok(estudianteService.getAllEstudiantes());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener estudiante por ID")
    public ResponseEntity<EstudianteDTO> getEstudianteById(@PathVariable Long id) {
        return ResponseEntity.of(estudianteService.getEstudianteById(id));
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo estudiante")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estudiante creado con éxito",
                    content = @Content(schema = @Schema(implementation = EstudianteDTO.class))),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")})
    public ResponseEntity<EstudianteDTO> createEstudiante(@RequestBody @ParameterObject EstudianteDTO estudianteDTO) {
        return ResponseEntity.ok(estudianteService.saveEstudiante(estudianteDTO));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable Long id) {
        estudianteService.deleteEstudiante(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

