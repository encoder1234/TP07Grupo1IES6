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
@Controller
public class DocenteController {
@Autowired
Docente unDocente;
@Qualifier("servicioDocenteBD")
@Autowired
IDocenteService docenteService;

@GetMapping("/Docente")
public ModelAndView getIndexWithDocente() {
    ModelAndView transportador = new ModelAndView("formDocente");
    transportador.addObject("docente", unDocente);  
    transportador.addObject("band", false);   
    return transportador;
}
@GetMapping("/listadoDocentes")
public ModelAndView getAllDocente() {
    ModelAndView transportador = new ModelAndView("listaDocentes");
    transportador.addObject("listadoDocentes", docenteService.ListarTodosDocentes());  
    return transportador;
}
@PostMapping("/guardarDocente")
public String guardarDocentes(Docente docente) {
    docenteService.guardarDocente(docente); 
    return "redirect:/listadoDocentes"; 
}
// Eliminar docente
@GetMapping("/eliminarDocente/{legajo}")
public String deleteDocente(@PathVariable(name = "legajo") Integer legajo) {
    docenteService.eliminarDocente(legajo); 
    return "redirect:/listadoDocentes"; 
}
// Modificar docente
@GetMapping("/modificarDocente/{legajo}")
public ModelAndView ModificarDocente(@PathVariable(name = "legajo") Integer legajo) {
    ModelAndView modelView = new ModelAndView("formDocente");
    modelView.addObject("docente", docenteService.consultarDocente(legajo)); 
    modelView.addObject("band", true); 
    return modelView;
  }
}
