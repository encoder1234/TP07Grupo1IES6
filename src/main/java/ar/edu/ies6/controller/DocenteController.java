package ar.edu.ies6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.ies6.model.Docente;
import ar.edu.ies6.service.imp.DocenteServiceImp;
@Controller 

public class DocenteController {


	@GetMapping("/index")
	public String getIndex() {
		System.out.println("esta pasando por aqui");
		return "index";
		}
@GetMapping("/Docente")
public ModelAndView getIndexWithDocente() {
	//codigo
	//creado el docente
	Docente unDocente = new Docente();
	//unDocente.setApellido("Caliva");
	//unDocente.setNombre("Milton");
	//unDocente.setDni("24826441");

	//transporte hacia la vista
ModelAndView Transportador = new ModelAndView("index");
Transportador.addObject("docente", unDocente);
return Transportador;
}
@PostMapping("/guardarDocente")
public ModelAndView guardarDocente(Docente docente) {
	DocenteServiceImp docenteService = new DocenteServiceImp();
	docenteService.guardarDocente(docente);
	
	ModelAndView Transportador = new ModelAndView("avisoExito");
	//Transportador.addObject("docente", unDocente);
	return Transportador;
}
	
}
