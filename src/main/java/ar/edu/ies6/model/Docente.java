package ar.edu.ies6.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Docente {

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Id
    private Integer legajo;

    @Column
    private Boolean estado;

    //@OneToMany(mappedBy = "docente") 
    //private List<Materia> materias; 

    public Docente() {
        // Constructor vacío
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getLegajo() {
        return legajo;
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

    public void setLegajo(Integer legajo) {
        this.legajo = legajo;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    
}
