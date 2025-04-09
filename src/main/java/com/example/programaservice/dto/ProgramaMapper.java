package com.example.programaservice.dto;

import com.example.programaservice.model.ProgramaAcademico;
import org.springframework.stereotype.Component;

@Component
public class ProgramaMapper {

    public ProgramaAcademico toEntity(ProgramaRequest request) {
        ProgramaAcademico programa = new ProgramaAcademico();
        programa.setNombre(request.nombre());
        programa.setDescripcion(request.descripcion());
        programa.setDuracion(request.duracion());
        programa.setIdCoordinador(request.idCoordinador());
        programa.setIdFacultad(request.idFacultad());
        programa.setNivelAcademico(request.nivelAcademico());
        programa.setNumeroCreditos(request.numeroCreditos());
        programa.setPerfilEgreso(request.perfilEgreso());
        // activo ya tiene valor por defecto
        return programa;
    }

    public ProgramaResponse toResponse(ProgramaAcademico programa) {
        return new ProgramaResponse(
                programa.getId(),
                programa.getNombre(),
                programa.isActivo(),
                programa.getDescripcion(),
                programa.getDuracion(),
                programa.getIdCoordinador(),
                programa.getIdFacultad(),
                programa.getNivelAcademico(),
                programa.getNumeroCreditos(),
                programa.getPerfilEgreso()
        );
    }
}