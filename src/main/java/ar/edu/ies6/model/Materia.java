package ar.edu.ies6.model;

import org.springframework.stereotype.Component;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Component
@Entity
public class Materia {

    @Column
    private String nombre;
    @Column
    private String codigo;
    @Id
    private String id;
    @Column
    private Boolean estado;
    public Materia() {
        // TODO Auto-generated constructor stub
    }
    public String getNombre() {
        return nombre;
    }
    public String getCodigo() {
        return codigo;
    }
    public String getId() {
        return id;
    }
    public Boolean isEstado() {
        return estado;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
