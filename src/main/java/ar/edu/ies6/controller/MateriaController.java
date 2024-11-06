package ar.edu.ies6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.ies6.model.Materia;
import ar.edu.ies6.service.IMateriaService;

@Controller
public class MateriaController {

    @Autowired
    Materia unaMateria;

    @Qualifier("servicioMateriaBD")
    @Autowired
    IMateriaService materiaService;

    @GetMapping("/Materia")
    public ModelAndView getIndexWithMateria() {
        ModelAndView Transportador = new ModelAndView("formMateria");
        Transportador.addObject("materia", unaMateria);
        Transportador.addObject("band", false); //Bandera 
        return Transportador;
    }

    // listadoMaterias
    @GetMapping("/listadoMaterias")
    public ModelAndView getAllMateria() {
        ModelAndView Transportador = new ModelAndView("listaMaterias");
        Transportador.addObject("listadoMaterias", materiaService.listarTodasMaterias());
        return Transportador;
    }

    @PostMapping("/guardarMateria")
    public ModelAndView guardarMateria(Materia materia) {
        materiaService.guardarMateria(materia);
        ModelAndView Transportador = new ModelAndView("listaMaterias");
        Transportador.addObject("listadoMaterias", materiaService.listarMateriasActivas());
        return Transportador;
    }

    // eliminar materia
    @GetMapping("/eliminarMateria/{codigo}")
    public ModelAndView deleteMateria(@PathVariable(name="codigo") String codigo) {
        materiaService.eliminarMateria(codigo);
        ModelAndView modelView = new ModelAndView("listaMaterias");
        modelView.addObject("listadoMaterias", materiaService.listarMateriasActivas());
        return modelView;
    }

    // modificar materia
    @GetMapping("/modificarMateria/{codigo}")
    public ModelAndView modificarMateria(@PathVariable(name="codigo") String codigo) {
        ModelAndView modelView = new ModelAndView("formMateria");
        modelView.addObject("materia", materiaService.consultarMateria(codigo));
        modelView.addObject("band", true); 
        return modelView;
    }
}
