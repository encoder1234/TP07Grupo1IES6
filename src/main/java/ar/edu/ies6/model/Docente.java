package ar.edu.ies6.model;

import org.springframework.stereotype.Component;

@Component

public class Docente {

    private String nombre;
    private String apellido;
    private String dni;
    public Docente() {
		// TODO Auto-generated constructor stub
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
    
}