package ar.edu.ies6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.ies6.model.Materia;
import ar.edu.ies6.repository.DocenteRepository;
import ar.edu.ies6.service.IAlumnoService;
import ar.edu.ies6.service.IMateriaService;

@Controller
public class MateriaController {

    @Autowired
    @Qualifier("servicioMateriaBD")
    IMateriaService materiaService;
    
    @Autowired
    Materia unaMateria;
    
    @Autowired
    DocenteRepository docenteRepository;
    
    @Autowired
    @Qualifier("servicioAlumnoBD")
    IAlumnoService alumnoService;
    
    @GetMapping("/Materia")
    public ModelAndView getFormularioMateria() {
        ModelAndView Transportador = new ModelAndView("formMateria");
        Transportador.addObject("materia", unaMateria);
        Transportador.addObject("listadoDocentes", docenteRepository.findAll()); 
        Transportador.addObject("listaAlumnos", alumnoService.ListarAlumnosActivos());
        Transportador.addObject("band", false);  // Si es un formulario nuevo
        return Transportador;
    }

    @PostMapping("/guardarMateria")
    public ModelAndView guardarMateria(Materia materia) {
        if (materia.getCodigo() != null && !materia.getCodigo().isEmpty()) {
            materiaService.guardarMateria(materia);
        } else {
            materiaService.guardarMateria(materia);
        }

        ModelAndView transportador = new ModelAndView("listaMaterias");
        transportador.addObject("listadoMaterias", materiaService.listarTodasMaterias());
        return transportador;
    }

    @GetMapping("/modificarMateria/{codigo}")
    public ModelAndView modificarMateria(@PathVariable(name="codigo") String codigo) {
        Materia materia = materiaService.consultarMateria(codigo);
        ModelAndView modelView = new ModelAndView("formMateria");
        modelView.addObject("materia", materia);
        modelView.addObject("band", true);  // Si es una modificación, band es true
        modelView.addObject("listadoDocentes", docenteRepository.findAll());
        return modelView;
    }

    @GetMapping("/eliminarMateria/{codigo}")
    public ModelAndView eliminarMateria(@PathVariable(name="codigo") String codigo) {
        try {
            materiaService.eliminarMateria(codigo);
        } catch (Exception e) {
            ModelAndView modelView = new ModelAndView("errorPage");
            modelView.addObject("error", "No se pudo eliminar la materia.");
            return modelView;
        }

        ModelAndView modelView = new ModelAndView("listaMaterias");
        modelView.addObject("listadoMaterias", materiaService.listarMateriasActivas());
        return modelView;
    }

    @GetMapping("/listarAlumnosDelaMateria/{codigo}")
    public ModelAndView listarAlumnosDeMateria(@PathVariable(name="codigo") String codigo){
        Materia materiaAListar = materiaService.consultarMateria(codigo);
        ModelAndView modelView = new ModelAndView("listaAlumnos");
        modelView.addObject("listadoAlumnos", materiaAListar.getAlumnos());
        return modelView;
    }

    @GetMapping("/listadoMaterias")  // Agregado este método
    public ModelAndView listadoMaterias() {
        ModelAndView modelAndView = new ModelAndView("listaMaterias");
        modelAndView.addObject("listadoMaterias", materiaService.listarTodasMaterias());
        return modelAndView;
    }
}

