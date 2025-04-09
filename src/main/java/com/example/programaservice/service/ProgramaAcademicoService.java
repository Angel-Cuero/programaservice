package com.example.programaservice.service;

import com.example.programaservice.dto.ProgramaMapper;
import com.example.programaservice.dto.ProgramaRequest;
import com.example.programaservice.dto.ProgramaResponse;
import com.example.programaservice.exception.ResourceNotFoundException;
import com.example.programaservice.model.ProgramaAcademico;
import com.example.programaservice.repository.ProgramaAcademicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class ProgramaAcademicoService {

    private final ProgramaAcademicoRepository repository;
    private final ProgramaMapper mapper;

    public ProgramaResponse createPrograma(ProgramaRequest request) {
        if (repository.existsByNombre(request.nombre())) {
            throw new IllegalArgumentException("Ya existe un programa con este nombre");
        }
        ProgramaAcademico programa = mapper.toEntity(request);
        programa.setActivo(true); // Valor por defecto
        return mapper.toResponse(repository.save(programa));
    }

    public ProgramaResponse getById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Programa no encontrado"));
    }

    public List<ProgramaResponse> getAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    public Page<ProgramaResponse> getAllPaginated(int page, int size) {
        return repository.findAll(PageRequest.of(page, size))
                .map(mapper::toResponse);
    }

    // Versión unificada para el nuevo enfoque
    public ProgramaResponse updatePrograma(ProgramaRequest request) {
        ProgramaAcademico existing = repository.findById(request.id())
                .orElseThrow(() -> new ResourceNotFoundException("Programa no encontrado"));

        // Actualizar solo campos permitidos
        existing.setNombre(request.nombre());
        existing.setDescripcion(request.descripcion());
        existing.setDuracion(request.duracion());
        existing.setIdCoordinador(request.idCoordinador());
        existing.setIdFacultad(request.idFacultad());
        existing.setNivelAcademico(request.nivelAcademico());
        existing.setNumeroCreditos(request.numeroCreditos());
        existing.setPerfilEgreso(request.perfilEgreso());

        return mapper.toResponse(repository.save(existing));
    }

    public void deletePrograma(Long id) {
        ProgramaAcademico programa = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Programa no encontrado"));

        // Soft delete (recomendado)
        programa.setActivo(false);
        repository.save(programa);
    }
}