package ar.edu.ies6.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	
@GetMapping("/docente/index")
public String getIndex() {
    System.out.println("esta pasando por aqui");
    return "index";
}

@GetMapping("/Docente")
public ModelAndView getIndexWithDocente() {
	//codigo

	//transporte hacia la vista
ModelAndView Transportador = new ModelAndView("formDocente");
Transportador.addObject("docente", unDocente);
return Transportador;
}
@PostMapping("/guardarDocente")
public ModelAndView guardarDocente(Docente docente) {
	//DocenteServiceImp docenteService = new DocenteServiceImp();
	docenteService.guardarDocente(docente);
	
	ModelAndView Transportador = new ModelAndView("listaDocentes");
	Transportador.addObject("listadoDocentes",docenteService.ListarTodosDocentes());
	return Transportador;
}

}
