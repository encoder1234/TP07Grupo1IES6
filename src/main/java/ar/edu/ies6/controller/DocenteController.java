package ar.edu.ies6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.ies6.model.Docente;
import ar.edu.ies6.service.IDocenteService;
import ar.edu.ies6.service.imp.DocenteServiceImp;
@Controller 
public class DocenteController {
	@Autowired
	Docente unDocente;
	@Qualifier("servicioDocenteBD")
	@Autowired
	IDocenteService docenteService;
@GetMapping("/Grupo1")
public String getIndex() {
    System.out.println("esta pasando por aqui");
    return "grupo1";
}
@GetMapping("/Docente")
public ModelAndView getIndexWithDocente() {
	//codigo
	//transporte hacia la vista
ModelAndView Transportador = new ModelAndView("formDocente");
Transportador.addObject("docente", unDocente);
Transportador.addObject("band", false);
return Transportador;
}
@GetMapping("/listadoDocentes")
public ModelAndView getAllDocente() {
	//codigo
	//transporte hacia la vista
ModelAndView Transportador = new ModelAndView("listaDocentes");
Transportador.addObject("listadoDocentes",docenteService.ListarTodosDocentes());
return Transportador;
}
@PostMapping("/guardarDocente")
public ModelAndView guardarDocentes(Docente docente) {
	//DocenteServiceImp docenteService = new DocenteServiceImp();
	docenteService.guardarDocente(docente);
	ModelAndView Transportador = new ModelAndView("listaDocentes");
	Transportador.addObject("listadoDocentes",docenteService.ListarTodosDocentesActivos());
	return Transportador;
}
//eliminar
@GetMapping ("/eliminarDocente/{dni}")
public ModelAndView deleteDocente (@PathVariable (name="dni") String dni){
	docenteService.eliminarDocente(dni);
	//mostrar el nuevo listado
	 ModelAndView modelView = new ModelAndView ("listaDocentes");
	 modelView.addObject("listadoDocentes",docenteService.ListarTodosDocentes());
	 return modelView;
}
//modificar
@GetMapping ("/modificarDocente/{dni}")
public ModelAndView ModificarDocente(@PathVariable (name="dni") String dni) {
	//el parametro de ModelAndView es una vista HTML
	ModelAndView modelView = new ModelAndView ("formDocente");
	modelView.addObject("docente",docenteService.consultarDocente(dni));
	modelView.addObject("band", true);
	
	return modelView;
}
}

