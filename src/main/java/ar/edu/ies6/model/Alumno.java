package ar.edu.ies6.model;

import java.util.List;

import org.springframework.stereotype.Component;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
@Component
@Entity
public class Alumno {
	@Column
    private String nombre;
	@Column
    private String apellido;
	@Id
    private String dni;
	@Column
    private Boolean estado;
	@ManyToMany (mappedBy="alumnos")
	private List<Materia>materias;
    public Alumno() {
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