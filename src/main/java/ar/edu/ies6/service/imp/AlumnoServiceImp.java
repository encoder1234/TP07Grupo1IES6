package ar.edu.ies6.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ar.edu.ies6.model.Alumno;
import ar.edu.ies6.service.IAlumnoService;
import ar.edu.ies6.util.AlmacenAlumnos;

@Service
@Qualifier("ServicioAlumnoBDArrayList")
public class AlumnoServiceImp implements IAlumnoService {

    @Override
    public void guardarAlumno(Alumno alumno) {
        AlmacenAlumnos.alumnos.add(alumno);
        System.out.println("Alumno agregado: " + alumno.getDni());
    }

    @Override
    public void eliminarAlumno(String dni) {
        Optional<Alumno> alumnoAEliminar = AlmacenAlumnos.alumnos.stream()
                .filter(alumno -> alumno.getDni().equals(dni))
                .findFirst();
        
        alumnoAEliminar.ifPresent(alumno -> AlmacenAlumnos.alumnos.remove(alumno));
    }

    @Override
    public void modificarAlumno(Alumno alumnoModificado) {
        // Buscar el alumno por DNI y actualizar los datos
        Optional<Alumno> alumnoExistente = AlmacenAlumnos.alumnos.stream()
                .filter(alumno -> alumno.getDni().equals(alumnoModificado.getDni()))
                .findFirst();

        alumnoExistente.ifPresent(alumno -> {
            alumno.setNombre(alumnoModificado.getNombre());
            alumno.setApellido(alumnoModificado.getApellido());
            alumno.setEstado(alumnoModificado.isEstado());
        });
    }

    @Override
    public Alumno consultarAlumno(String dni) {
        // Buscar un alumno por dni
        return AlmacenAlumnos.alumnos.stream()
                .filter(alumno -> alumno.getDni().equals(dni))
                .findFirst()
                .orElse(null); // devuleve nada
    }

    @Override
    public List<Alumno> ListarTodosAlumnos() {
        return AlmacenAlumnos.alumnos;
    }

    @Override
    public List<Alumno> ListarAlumnosActivos() {
        // Filtra solo los alumnos activos
        return AlmacenAlumnos.alumnos.stream()
                .filter(Alumno::isEstado) // Verifica of/on
                .toList();
    }
}
