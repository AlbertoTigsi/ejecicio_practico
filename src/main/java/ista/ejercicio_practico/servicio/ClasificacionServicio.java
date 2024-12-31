package ista.ejercicio_practico.servicio;
import ista.ejercicio_practico.modelo.Clasificacion;
import ista.ejercicio_practico.repositorio.ClasificacionRepositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClasificacionServicio {

    
    @Autowired
    ClasificacionRepositorio clasificacionRepositorio;


    public Clasificacion insertar(Clasificacion obj) {
        try {
            return clasificacionRepositorio.save(obj);
        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
            throw new RuntimeException("Error al insertar la clasificación", e);
        }
    }

     // Método para editar (actualizar)
     public Clasificacion editar(Clasificacion obj) {
        try {
            
            if (clasificacionRepositorio.existsById(obj.getIdClasificacion())) {
                return clasificacionRepositorio.save(obj); // Guarda o actualiza el objeto
            } else {
                throw new RuntimeException("Clasificación no encontrada para actualizar");
            }
        } catch (Exception e) {
            System.out.println("Error al editar: " + e.getMessage());
            throw new RuntimeException("Error al editar la clasificación", e);
        }
    }

    // Método para eliminar
    public void eliminar(Long idClasificacion) {
        try {
            if (clasificacionRepositorio.existsById(idClasificacion)) {
                clasificacionRepositorio.deleteById(idClasificacion); // Elimina el objeto
            } else {
                throw new RuntimeException("Clasificación no encontrada para eliminar");
            }
        } catch (Exception e) {
          
            System.out.println("Error al eliminar: " + e.getMessage());
            throw new RuntimeException("Error al eliminar la clasificación", e);
        }
    }

    public List<Clasificacion> listar() {
        try {
            return clasificacionRepositorio.findAll();
        } catch (Exception e) {
            System.out.println("Error al listar los Clasificacion: " + e.getMessage());
            throw new RuntimeException("Error al listar los Clasificacion", e);
        }
    }
    
}
