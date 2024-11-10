package ar.edu.ies6.service.imp;


import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ar.edu.ies6.model.Docente;
import ar.edu.ies6.service.IDocenteService;
import ar.edu.ies6.util.AlmacenDocentes;

@Service
@Qualifier("ServicioDocenteBDArrayList")
public class DocenteServiceImp implements IDocenteService{

	@Override
	public void guardarDocente(Docente docente) {
		// TODO Auto-generated method stub
AlmacenDocentes.docentes.add(docente);

System.out.println(AlmacenDocentes.docentes.get(0).getLegajo());

	}

	@Override
	public void eliminarDocente(Integer legajo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarDocente(Docente docenteModificado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Docente consultarDocente(Integer legajo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Docente> ListarTodosDocentes() {
		// TODO Auto-generated method stub
		//filtrar por docente en estado activo
		return AlmacenDocentes.docentes;
	}

	@Override
	public List<Docente> ListarDocentesActivos() {
		// TODO Auto-generated method stub
		return null;
	}

	

}

