package co.edu.uceva.programaservice.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Programa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El campo 'activo' es obligatorio")
    private Boolean activo;

    @NotNull(message = "La descripcion es obligatoria")
    private String descripcion;

    @NotNull(message = "La duracion es obligatoria")
    private Long duracion;

    @NotNull(message = "El ID del coordinador es obligatorio")
    private Long idCoordinador;

    @NotNull(message = "El ID de la facultad es obligatoria")
    private Long idFacultad;

    @NotNull(message = "El nivel academico es obligatorio")
    private String nivelAcademico;

    @NotNull(message = "El nombre es obligatorio")
    private String nombre;

    @NotNull(message = "El numero de creditos es obligatorio")
    private Byte numeroCreditos;

    @NotNull(message = "El perfil de egreso es obligatorio")
    private String perfilEgreso;

}

