package ar.edu.ies6.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ar.edu.ies6.model.Materia;
import ar.edu.ies6.repository.MateriaRepository;
import ar.edu.ies6.service.IMateriaService;

@Service
@Qualifier("servicioMateriaBD")
public class MateriaServiceImpBD implements IMateriaService {

    @Autowired
    MateriaRepository materiaRepository;

    @Override
    public void guardarMateria(Materia materia) {
        materiaRepository.save(materia);
    }

    @Override
    public void eliminarMateria(String codigo) {
        // TODO Auto-generated method stub
    }

    @Override
    public void modificarMateria(Materia materiaModificada) {
        // TODO Auto-generated method stub
    }

    @Override
    public void consultarMateria(String codigo) {
        // TODO Auto-generated method stub
    }

    @Override
    public List<Materia> listarTodasMaterias() {
        return (List<Materia>) materiaRepository.findAll();
    }
}
