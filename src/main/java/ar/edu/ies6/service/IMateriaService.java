package ar.edu.ies6.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ar.edu.ies6.model.Materia;
@Service
public interface IMateriaService {
    //crud
    public void guardarMateria(Materia materia);
    public void eliminarMateria(String codigo);
    public void modificarMateria(Materia materiaModificada);
    public Materia consultarMateria(String codigo);
    public List<Materia> listarTodasMaterias();
    public List<Materia> listarMateriasActivas();
}
