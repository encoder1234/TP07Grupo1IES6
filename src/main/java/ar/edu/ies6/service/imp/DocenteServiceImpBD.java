package ar.edu.ies6.service.imp;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ar.edu.ies6.model.Docente;
import ar.edu.ies6.repository.DocenteRepository;
import ar.edu.ies6.service.IDocenteService;

@Service
@Qualifier("servicioDocenteBD")
public class DocenteServiceImpBD implements IDocenteService {    

    @Autowired
    DocenteRepository docenteRepository;

    @Override
    public void guardarDocente(Docente docente) {
        docente.setEstado(true);
        docenteRepository.save(docente);
    }

    @Override
    public void eliminarDocente(Integer legajo) { 
        Optional<Docente> docenteEncontrado = docenteRepository.findById(legajo); 
        if (docenteEncontrado.isPresent()) {
            docenteEncontrado.get().setEstado(false);
            docenteRepository.save(docenteEncontrado.get());
        }
    }

    @Override
    public void modificarDocente(Docente docenteModificado) {
        
    }

    @Override
    public Docente consultarDocente(Integer legajo) {
        Optional<Docente> docenteEncontrado = docenteRepository.findById(legajo);
        return docenteEncontrado.orElse(null);
    }

    @Override
    public List<Docente> ListarTodosDocentes() {
        return (List<Docente>) docenteRepository.findAll();
    }

    @Override
    public List<Docente> ListarDocentesActivos() {
        return docenteRepository.findByEstado(true);
    }

	
}
