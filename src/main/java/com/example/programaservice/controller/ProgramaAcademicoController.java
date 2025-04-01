package com.example.programaservice.controller;

import com.example.programaservice.dto.ProgramaRequest;
import com.example.programaservice.dto.ProgramaResponse;
import com.example.programaservice.service.ProgramaAcademicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programas")
@RequiredArgsConstructor
public class ProgramaAcademicoController {

    private final ProgramaAcademicoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProgramaResponse create(@Valid @RequestBody ProgramaRequest request) {
        return service.createPrograma(request);
    }

    @GetMapping("/{id}")
    public ProgramaResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<ProgramaResponse> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public ProgramaResponse update(@PathVariable Long id, @Valid @RequestBody ProgramaRequest request) {
        return service.updatePrograma(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.deletePrograma(id);
    }
}