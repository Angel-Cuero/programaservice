package com.example.programaservice.service;

import com.example.programaservice.dto.ProgramaRequest;
import com.example.programaservice.dto.ProgramaResponse;
import com.example.programaservice.exception.ResourceNotFoundException;
import com.example.programaservice.model.ProgramaAcademico;
import com.example.programaservice.repository.ProgramaAcademicoRepository;
import com.example.programaservice.dto.ProgramaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgramaAcademicoService {

    private final ProgramaAcademicoRepository repository;

    public ProgramaResponse createPrograma(ProgramaRequest request) {
        ProgramaAcademico programa = ProgramaMapper.toEntity(request);
        return ProgramaMapper.toResponse(repository.save(programa));
    }

    public ProgramaResponse getById(Long id) {
        return ProgramaMapper.toResponse(
                repository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Programa no encontrado"))
        );
    }

    public List<ProgramaResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(ProgramaMapper::toResponse)
                .toList();
    }

    public ProgramaResponse updatePrograma(Long id, ProgramaRequest request) {
        ProgramaAcademico existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Programa no encontrado"));

        ProgramaAcademico updated = ProgramaMapper.toEntity(request);
        updated.setId(existing.getId());
        return ProgramaMapper.toResponse(repository.save(updated));
    }

    public void deletePrograma(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Programa no encontrado");
        }
        repository.deleteById(id);
    }
}