
package ar.edu.ies6.service;


import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.ies6.model.Docente;

@Service
public interface IDocenteService {
	//crud
	public void guardarDocente(Docente docente);
	public void eliminarDocente(Integer legajo);
	public void modificarDocente(Docente docenteModificado);
	public Docente consultarDocente(Integer legajo);
	public List<Docente> ListarTodosDocentes();
	public List<Docente> ListarDocentesActivos();

}
