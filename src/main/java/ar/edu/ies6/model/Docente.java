package ar.edu.ies6.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Component
@Entity

public class Docente {
	@Column
    private String nombre;
	@Column
    private String apellido;
	@Id
    private String dni;
	@Column
    private Boolean estado;
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
	public Boolean isEstado() {
		return estado;
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
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
}