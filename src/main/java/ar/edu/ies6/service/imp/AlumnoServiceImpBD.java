package ar.edu.ies6.service.imp;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ar.edu.ies6.model.Alumno;
import ar.edu.ies6.repository.AlumnoRepository;
import ar.edu.ies6.service.IAlumnoService;
@Service
@Qualifier("servicioAlumnoBD")
public class AlumnoServiceImpBD implements IAlumnoService{
@Autowired
AlumnoRepository alumnoRepository;
	@Override
	public void guardarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		//guardar en la BD
		alumno.setEstado(true);
		alumnoRepository.save(alumno);
	}
	@Override
	public void eliminarAlumno(String dni) {
		// TODO Auto-generated method stub
		Optional<Alumno> alumnoEncontrado = alumnoRepository.findById(dni);
		alumnoEncontrado.get().setEstado(false);
		alumnoRepository.save(alumnoEncontrado.get());
	}
	@Override
	public void modificarAlumno(Alumno alumnoModificado) {
		// TODO Auto-generated method stub
	}
	@Override
	public void consultarAlumno(String dni) {
		// TODO Auto-generated method stub	
	}
	@Override
	public List<Alumno> ListarTodosAlumnos() {
		// TODO Auto-generated method stub
		return (List<Alumno>) alumnoRepository.findAll();
	}
	@Override
	public List<Alumno> ListarAlumnosActivos() {
		// TODO Auto-generated method stub
		return (List<Alumno>) alumnoRepository.findByEstado(true);
	}
}
