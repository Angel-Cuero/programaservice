// ProgramaResponse.java
package com.example.programaservice.dto;

public record ProgramaResponse(
        Long id,
        String nombre,
        boolean activo,
        String descripcion,
        Long duracion,
        Long idCoordinador,
        Long idFacultad,
        String nivelAcademico,
        Byte numeroCreditos,
        String perfilEgreso
) {}