package com.example.programaservice.dto;

import com.example.programaservice.model.ProgramaAcademico;

public class ProgramaMapper {
    public static ProgramaResponse toResponse(ProgramaAcademico entity) {
        return new ProgramaResponse(
                entity.getId(),
                entity.getNombre(),
                entity.isActivo(),
                entity.getDescripcion(),
                entity.getDuracion(),
                entity.getIdCoordinador(),
                entity.getIdFacultad(),
                entity.getNivelAcademico(),
                entity.getNumeroCreditos(),
                entity.getPerfilEgreso()
        );
    }

    public static ProgramaAcademico toEntity(ProgramaRequest request) {
        ProgramaAcademico entity = new ProgramaAcademico();
        entity.setNombre(request.nombre());
        entity.setDescripcion(request.descripcion());
        entity.setDuracion(request.duracion());
        entity.setIdCoordinador(request.idCoordinador());
        entity.setIdFacultad(request.idFacultad());
        entity.setNivelAcademico(request.nivelAcademico());
        entity.setNumeroCreditos(request.numeroCreditos());
        entity.setPerfilEgreso(request.perfilEgreso());
        return entity;
    }
}