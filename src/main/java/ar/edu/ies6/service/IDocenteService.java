package ar.edu.ies6.service;


import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.ies6.model.Docente;

@Service
public interface IDocenteService {
	//crud
	public void guardarDocente(Docente docente);
	public void eliminarDocente(String dni);
	public void modificarDocente(Docente docenteModificado);
	public void consultarDocente(String dni);
	public List<Docente> ListarTodosDocentes();

}
