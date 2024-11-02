package ar.edu.ies6.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import ar.edu.ies6.model.Materia;
public interface MateriaRepository extends CrudRepository<Materia, String> {
List<Materia> findByEstado(Boolean estado);
}
