package ar.edu.ies6.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ar.edu.ies6.model.Materia;
import ar.edu.ies6.service.IMateriaService;
import ar.edu.ies6.util.AlmacenMaterias;

@Service
@Qualifier("ServicioMateriaBDArrayList")
public class MateriaServiceImp implements IMateriaService {

    @Override
    public void guardarMateria(Materia materia) {
        AlmacenMaterias.materias.add(materia);
        System.out.println(AlmacenMaterias.materias.get(0).getCodigo());
    }
    @Override
    public void eliminarMateria(String codigo) {
        // TODO Auto-generated method stub
    }
    @Override
    public void modificarMateria(Materia materiaModificada) {
        // TODO Auto-generated method stub
    }
    @Override
    public Materia consultarMateria(String codigo) {
        // TODO Auto-generated method stub
        return null; 
    }
    @Override
    public List<Materia> listarTodasMaterias() {
        //materia en estado activo
        return AlmacenMaterias.materias;
    }
    @Override
    public List<Materia> listarMateriasActivas() {
        // TODO Auto-generated method stub
        return null;
    }
}
