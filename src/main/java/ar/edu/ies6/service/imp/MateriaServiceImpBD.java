package ar.edu.ies6.service.imp;

import java.util.List;
import java.util.Optional;

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
    private MateriaRepository materiaRepository;

    @Override
    public void guardarMateria(Materia materia) {
        materia.setEstado(true); 
        materiaRepository.save(materia);
    }

    @Override
    public void eliminarMateria(String codigo) {
        Optional<Materia> materiaEncontrada = materiaRepository.findById(codigo);
        if (materiaEncontrada.isPresent()) {
            Materia materia = materiaEncontrada.get();
            materia.setEstado(false); //ocultar
            materiaRepository.save(materia);
        }
    }

    @Override
    public void modificarMateria(Materia materiaModificada) {
        Optional<Materia> materiaExistente = materiaRepository.findById(materiaModificada.getCodigo());
        if (materiaExistente.isPresent()) {
            Materia materia = materiaExistente.get();
            materia.setNombre(materiaModificada.getNombre());
            materia.setEstado(materiaModificada.getEstado());  
            materiaRepository.save(materia);
        }
    }

    @Override
    public Materia consultarMateria(String codigo) {
        Optional<Materia> materiaEncontrada = materiaRepository.findById(codigo);
        return materiaEncontrada.orElse(null);  // Retorna la materia o null si no existe
    }

    @Override
    public List<Materia> listarTodasMaterias() {
        return (List<Materia>) materiaRepository.findAll();  // Retorna todas las materias
    }

    @Override
    public List<Materia> listarMateriasActivas() {
        return materiaRepository.findByEstado(true);  // Filtra las materias activas
    }

	@Override
	public void ocultarMateria(String codigo) {
		// TODO Auto-generated method stub
		
	}
}
