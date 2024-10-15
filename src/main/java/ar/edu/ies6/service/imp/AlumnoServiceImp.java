package ar.edu.ies6.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.ies6.model.Alumno;
import ar.edu.ies6.service.IAlumnoService;
import ar.edu.ies6.util.AlmacenAlumnos;

@Service
public class AlumnoServiceImp implements IAlumnoService{

	@Override
	public void guardarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		AlmacenAlumnos.AlmacenAlumnos.add(alumno);
		//System.out.println(AlmacenAlumnos.AlmacenAlumnos.get(0).getDni());
	}

	@Override
	public void eliminarAlumno(String dni) {
		// TODO Auto-generated method stub
		
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
	public List<Alumno> ListarAlumnos() {
		// TODO Auto-generated method stub
		return null;
	}

}
