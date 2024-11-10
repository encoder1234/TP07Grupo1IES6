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
        transportador.addObject("docente", unDocente);  // Se pasa el objeto docente vacío
        transportador.addObject("band", false);          // 'band' se usa para el control de readonly en el legajo
        return transportador;
    }

    @GetMapping("/listadoDocentes")
    public ModelAndView getAllDocente() {
        ModelAndView transportador = new ModelAndView("listaDocentes");
        transportador.addObject("listadoDocentes", docenteService.ListarTodosDocentes());  // Se lista todos los docentes
        return transportador;
    }

    @PostMapping("/guardarDocente")
    public String guardarDocentes(Docente docente) {
        docenteService.guardarDocente(docente);  // Se guarda el docente
        return "redirect:/listadoDocentes";  // Redirige a la lista de docentes después de guardar
    }

    // Eliminar docente
    @GetMapping("/eliminarDocente/{legajo}")
    public String deleteDocente(@PathVariable(name = "legajo") Integer legajo) {
        docenteService.eliminarDocente(legajo);  // Elimina el docente por legajo
        return "redirect:/listadoDocentes";  // Redirige nuevamente a la lista de docentes
    }

    // Modificar docente
    @GetMapping("/modificarDocente/{legajo}")
    public ModelAndView ModificarDocente(@PathVariable(name = "legajo") Integer legajo) {
        ModelAndView modelView = new ModelAndView("formDocente");
        modelView.addObject("docente", docenteService.consultarDocente(legajo));  // Trae el docente por legajo para editar
        modelView.addObject("band", true);  // 'band' para permitir editar el legajo
        return modelView;
    }
}
