package ar.edu.ies6.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import ar.edu.ies6.model.Alumno;
public interface AlumnoRepository extends CrudRepository <Alumno, String> {
List <Alumno> findByEstado(Boolean estado);
}
