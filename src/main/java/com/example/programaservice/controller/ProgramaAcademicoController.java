package com.example.programaservice.controller;

import com.example.programaservice.dto.ProgramaRequest;
import com.example.programaservice.dto.ProgramaResponse;
import com.example.programaservice.service.ProgramaAcademicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/programa-service")
@RequiredArgsConstructor
public class ProgramaAcademicoController {

    private final ProgramaAcademicoService service;

    // Obtener todos los programas (sin paginación)
    @GetMapping("/programas")
    public List<ProgramaResponse> getAllProgramas() {
        return service.getAll();
    }

    // Obtener programas paginados
    @GetMapping("/programa/page/{page}")
    public Page<ProgramaResponse> getProgramasPaginados(@PathVariable int page) {
        return service.getAllPaginated(page, 10); // 10 items por página
    }

    // Crear nuevo programa
    @PostMapping("/programas")
    @ResponseStatus(HttpStatus.CREATED)
    public ProgramaResponse createPrograma(@Valid @RequestBody ProgramaRequest request) {
        return service.createPrograma(request);
    }

    // Actualizar programa (ahora requiere ID en el body)
    @PutMapping("/programas")
    public ProgramaResponse updatePrograma(@Valid @RequestBody ProgramaRequest request) {
        return service.updatePrograma(request);
    }

    // Eliminar programa (ahora por query param)
    @DeleteMapping("/programas")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePrograma(@RequestParam Long id) {
        service.deletePrograma(id);
    }

    // Obtener programa por ID
    @GetMapping("/programas/{id}")
    public ProgramaResponse getProgramaById(@PathVariable Long id) {
        return service.getById(id);
    }
}