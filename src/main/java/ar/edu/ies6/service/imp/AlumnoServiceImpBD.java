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
public class AlumnoServiceImpBD implements IAlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public void guardarAlumno(Alumno alumno) {
        alumno.setEstado(true);
        alumnoRepository.save(alumno);
    }

    @Override
    public void eliminarAlumno(String dni) {
        Optional<Alumno> alumnoEncontrado = alumnoRepository.findById(dni);
        if (alumnoEncontrado.isPresent()) {
            Alumno alumno = alumnoEncontrado.get();
            alumno.setEstado(false);  
            alumnoRepository.save(alumno); 
        } else {
            System.out.println("Alumno no encontrado con DNI: " + dni);
        }
    }

    @Override
    public void modificarAlumno(Alumno alumnoModificado) {
        Optional<Alumno> alumnoExistente = alumnoRepository.findById(alumnoModificado.getDni());
        if (alumnoExistente.isPresent()) {
            Alumno alumno = alumnoExistente.get();
            alumno.setNombre(alumnoModificado.getNombre());
            alumno.setApellido(alumnoModificado.getApellido());
            alumno.setEstado(alumnoModificado.isEstado()); 
            alumnoRepository.save(alumno); 
        } else {
            System.out.println("Alumno no encontrado con DNI: " + alumnoModificado.getDni());
        }
    }

    @Override
    public Alumno consultarAlumno(String dni) {
        // Buscar el alumno por DNI
        Optional<Alumno> alumnoEncontrado = alumnoRepository.findById(dni);
        return alumnoEncontrado.orElse(null); // Retorna el alumno si lo encuentra, sino null
    }

    @Override
    public List<Alumno> ListarTodosAlumnos() {
        // Obtener todos los alumnos desde la BD
        return (List<Alumno>) alumnoRepository.findAll();
    }

    @Override
    public List<Alumno> ListarAlumnosActivos() {
        // Obtener los alumnos con estado activo desde la BD
        return alumnoRepository.findByEstado(true); // Método que debe estar en el repositorio
    }
}
