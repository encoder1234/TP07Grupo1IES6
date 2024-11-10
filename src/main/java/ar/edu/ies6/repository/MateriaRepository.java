package ar.edu.ies6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.ies6.model.Materia;
@Repository
public interface MateriaRepository extends JpaRepository<Materia,String>{
	List<Materia> findByEstado(Boolean estado);
}
