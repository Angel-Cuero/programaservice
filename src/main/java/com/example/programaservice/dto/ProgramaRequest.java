// ProgramaRequest.java
package com.example.programaservice.dto;

import jakarta.validation.constraints.*;

public record ProgramaRequest(
        @NotBlank String nombre,
        @NotBlank @Size(max = 500) String descripcion,
        @NotNull @Positive Long duracion,
        @NotNull Long idCoordinador,
        @NotNull Long idFacultad,
        @NotBlank @Size(max = 50) String nivelAcademico,
        @NotNull @Positive Byte numeroCreditos,
        @NotBlank @Size(max = 1000) String perfilEgreso
) {}