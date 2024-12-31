package ista.ejercicio_practico.servicio;
import ista.ejercicio_practico.modelo.Rol;
import ista.ejercicio_practico.repositorio.RolRepositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RolServicio {

    @Autowired
    RolRepositorio rolRepositorio;

    public Rol insertar(Rol obj) {
        try {
            return rolRepositorio.save(obj);
        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
            throw new RuntimeException("Error al insertar la clasificación", e);
        }
    }

     // Método para editar (actualizar)
     public Rol editar(Rol obj) {
        try {
            
            if (rolRepositorio.existsById(obj.getIdRol())) {
                return rolRepositorio.save(obj); // Guarda o actualiza el objeto
            } else {
                throw new RuntimeException("Rol no encontrada para actualizar");
            }
        } catch (Exception e) {
            System.out.println("Error al editar: " + e.getMessage());
            throw new RuntimeException("Error al editar la clasificación", e);
        }
    }

    // Método para eliminar
    public void eliminar(Long idRol) {
        try {
            if (rolRepositorio.existsById(idRol)) {
                rolRepositorio.deleteById(idRol); // Elimina el objeto
            } else {
                throw new RuntimeException("Rol no encontrada para eliminar");
            }
        } catch (Exception e) {
          
            System.out.println("Error al eliminar: " + e.getMessage());
            throw new RuntimeException("Error al eliminar la clasificación", e);
        }
    } 

    public List<Rol> listar() {
        try {
            return rolRepositorio.findAll();
        } catch (Exception e) {
            System.out.println("Error al listar los Rol: " + e.getMessage());
            throw new RuntimeException("Error al listar los Rol", e);
        }
    }
}
