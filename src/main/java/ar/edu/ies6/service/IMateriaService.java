package ar.edu.ies6.service;

import java.util.List;
import ar.edu.ies6.model.Materia;

public interface IMateriaService {

    void guardarMateria(Materia materia);
    void eliminarMateria(String codigo);
    void modificarMateria(Materia materiaModificada);
    Materia consultarMateria(String codigo);
    List<Materia> listarTodasMaterias();
    List<Materia> listarMateriasActivas();  
    void ocultarMateria(String codigo); 
}

