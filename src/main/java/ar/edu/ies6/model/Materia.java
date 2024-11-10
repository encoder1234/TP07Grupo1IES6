package ar.edu.ies6.model;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.ies6.util.Año;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Component
@Entity
public class Materia {

@Column
private String nombre;
@Id
private String codigo;
@Column
@Enumerated(EnumType.STRING)
private Año año;
@Column
private Boolean estado; 
@ManyToOne
private Docente docente;
@ManyToMany
private List<Alumno> alumnos;

public Materia() {
        // Constructor vacío
    }

    public String getNombre() {
        return nombre;
    }
    public String getCodigo() {
        return codigo;
    }
    public Año getAño() {
        return año;
    }
    public Boolean getEstado() {
        return estado;
    }
    public List<Alumno> getAlumnos() {
        return alumnos;
    }
    public Docente getDocente() {
        return docente;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setAño(Año año) {
        this.año = año;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    public void setDocente(Docente docente) {
        this.docente = docente;
    }
}
