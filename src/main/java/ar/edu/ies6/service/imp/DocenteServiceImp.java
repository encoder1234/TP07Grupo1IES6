package ar.edu.ies6.service.imp;

import java.util.List;
import org.springframework.stereotype.Service;
import ar.edu.ies6.model.Docente;
import ar.edu.ies6.service.IDocenteService;
import ar.edu.ies6.util.AlmacenDocentes;

@Service
public class DocenteServiceImp implements IDocenteService{

	@Override
	public void guardarDocente(Docente docente) {
		// TODO Auto-generated method stub
		AlmacenDocentes.AlmacenDocentes.add(docente);
		//System.out.println(AlmacenDocentes.AlmacenDocentes.get(0).getDni());
	}

	@Override
	public void eliminarDocente(String dni) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarDocente(Docente docenteModificado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void consultarDocente(String dni) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Docente> ListarDocente() {
		// TODO Auto-generated method stub
		return null;
	}

}
