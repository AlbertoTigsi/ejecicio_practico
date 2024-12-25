package ista.ejercicio_practico.modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clasificacion")
public class Clasificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clasificacion", nullable = false)
    private Long idClasificacion;
    
    @Column(name = "grupo", nullable = false)
    private String grupo;   

    public Long getIdClasificacion() {
        return idClasificacion;
    }

    // Setter para idClasificacion
    public void setIdClasificacion(Long idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    // Getter para grupo
    public String getGrupo() {
        return grupo;
    }

    // Setter para grupo
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    
}
