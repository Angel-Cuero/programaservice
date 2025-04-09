package com.example.programaservice.repository;

import com.example.programaservice.model.ProgramaAcademico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramaAcademicoRepository extends JpaRepository<ProgramaAcademico, Long> {
    boolean existsByNombre(String nombre);
}