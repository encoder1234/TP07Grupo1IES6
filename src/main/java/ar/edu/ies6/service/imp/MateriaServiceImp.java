package ar.edu.ies6.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ar.edu.ies6.model.Materia;
import ar.edu.ies6.repository.MateriaRepository;
import ar.edu.ies6.service.IMateriaService;

@Service
@Qualifier("servicioMateriaArrayList")  
public class MateriaServiceImp implements IMateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    @Override
    public void guardarMateria(Materia materia) {
        materia.setEstado(true);  
        materiaRepository.save(materia);
    }

    @Override
    public Materia consultarMateria(String codigo) {
        return materiaRepository.findByCodigo(codigo);
    }

    @Override
    public void eliminarMateria(String codigo) {
        materiaRepository.deleteById(codigo);  
    }

    @Override
    public void ocultarMateria(String codigo) {
        Materia materia = materiaRepository.findByCodigo(codigo);
        if (materia != null) {
            materia.setEstado(false);  
            materiaRepository.save(materia);
        }
    }

    @Override
    public List<Materia> listarTodasMaterias() {
        return materiaRepository.findAll(); 
    }

    @Override
    public List<Materia> listarMateriasActivas() {
        return materiaRepository.findByEstado(true);  
    }

    @Override
    public void modificarMateria(Materia materiaModificada) {
        // TODO Auto-generated method stub
    }
}

