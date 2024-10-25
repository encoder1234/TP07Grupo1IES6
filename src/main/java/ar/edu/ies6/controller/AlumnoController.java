package ar.edu.ies6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.ies6.model.Alumno;
import ar.edu.ies6.service.IAlumnoService;
import ar.edu.ies6.service.imp.AlumnoServiceImp;
@Controller 
public class AlumnoController {
	
	@Autowired
	Alumno unAlumno;
	@Qualifier("servicioAlumnoBD")
	@Autowired
	IAlumnoService alumnoService;
	
@GetMapping("/Grupo1")
public String getIndex() {
    System.out.println("esta pasando por aqui");
    return "grupo1";
}

@GetMapping("/Alumno")
public ModelAndView getIndexWithAlumno() {
	//codigo

	//transporte hacia la vista
ModelAndView Transportador = new ModelAndView("formAlumno");
Transportador.addObject("alumno", unAlumno);
return Transportador;
}
@PostMapping("/guardarAlumno")
public ModelAndView guardarAlumno(Alumno alumno) {
	//AlumnoServiceImp alumnoService = new AlumnoServiceImp();
	alumnoService.guardarAlumno(alumno);
	
	ModelAndView Transportador = new ModelAndView("listaAlumnos");
	Transportador.addObject("listadoAlumnos",alumnoService.ListarTodosAlumnos());
	return Transportador;
}

}
