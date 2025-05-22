package co.edu.uceva.programaservice.domain.repository;

import co.edu.uceva.programaservice.domain.model.Programa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface que hereda de JpaRepository para realizar las
 * operaciones de CRUD paginacion y ordenamiento sobre la entidad Semestre
 */
public interface IProgramaRepository extends JpaRepository<Programa, Long> {
}
