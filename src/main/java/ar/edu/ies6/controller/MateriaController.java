package ar.edu.ies6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
        return Transportador;
    }

    @PostMapping("/guardarMateria")
    public ModelAndView guardarMateria(Materia materia) {
        materiaService.guardarMateria(materia);
        ModelAndView Transportador = new ModelAndView("listaMaterias");
        Transportador.addObject("listadoMaterias", materiaService.listarTodasMaterias());
        return Transportador;
    }
}
