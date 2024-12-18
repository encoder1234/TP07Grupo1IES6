package ar.edu.ies6.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	//transporte hacia la vista
ModelAndView Transportador = new ModelAndView("formAlumno");
Transportador.addObject("alumno", unAlumno);
Transportador.addObject("band", false);
return Transportador;
}
@GetMapping("/listadoAlumnos")
public ModelAndView getAllAlumno() {
	//transporte hacia la vista
ModelAndView Transportador = new ModelAndView("listaAlumnos");
Transportador.addObject("listadoAlumnos",alumnoService.ListarTodosAlumnos());
return Transportador;
}
//guardar
@PostMapping("/guardarAlumno")
public ModelAndView guardarAlumno(Alumno alumno) {
	alumnoService.guardarAlumno(alumno);
	ModelAndView Transportador = new ModelAndView("listaAlumnos");
	Transportador.addObject("listadoAlumnos",alumnoService.ListarAlumnosActivos());
	return Transportador;
}
//eliminar
@GetMapping ("/eliminarAlumno/{dni}")
public ModelAndView deleteAlumno (@PathVariable (name="dni") String dni){
	alumnoService.eliminarAlumno(dni);
	//mostrar el nuevo listado
	 ModelAndView modelView = new ModelAndView ("listaAlumnos");
	 modelView.addObject("listadoAlumnos",alumnoService.ListarAlumnosActivos());
	 return modelView;
}
//modificar
@GetMapping ("/modificarAlumno/{dni}")
public ModelAndView ModificarAlumno(@PathVariable (name="dni") String dni) {
	//el parametro de ModelAndView es una vista HTML
	ModelAndView modelView = new ModelAndView ("formAlumno");
	modelView.addObject("alumno",alumnoService.consultarAlumno(dni));
	modelView.addObject("band", true);
	return modelView;
}
}

