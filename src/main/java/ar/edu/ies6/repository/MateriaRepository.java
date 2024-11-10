package ar.edu.ies6.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.ies6.model.Materia;

public interface MateriaRepository extends JpaRepository<Materia, String> {
    Materia findByCodigo(String codigo);
    List<Materia> findByEstado(Boolean estado);  
}
