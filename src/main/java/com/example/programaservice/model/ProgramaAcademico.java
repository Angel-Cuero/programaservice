package com.example.programaservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "programa_academico")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramaAcademico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private boolean activo = true;

    @Column(nullable = false, length = 500)
    private String descripcion;

    @Column(nullable = false)
    private Long duracion; // En meses

    @Column(name = "id_coordinador", nullable = false)
    private Long idCoordinador;

    @Column(name = "id_facultad", nullable = false)
    private Long idFacultad;

    @Column(nullable = false, length = 50)
    private String nivelAcademico;

    @Column(nullable = false, unique = true, length = 100)
    private String nombre;

    @Column(nullable = false)
    private byte numeroCreditos;

    @Column(nullable = false, length = 1000)
    private String perfilEgreso;
}