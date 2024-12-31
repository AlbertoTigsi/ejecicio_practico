package ista.ejercicio_practico.servicio;
import ista.ejercicio_practico.modelo.Proveedor;
import ista.ejercicio_practico.repositorio.ProveedorRepositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProveedorServicio {
     @Autowired
    ProveedorRepositorio proveedorRepositorio;

    public Proveedor insertar(Proveedor obj) {
        try {
            return proveedorRepositorio.save(obj);
        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
            throw new RuntimeException("Error al insertar la clasificación", e);
        }
    }

     // Método para editar (actualizar)
     public Proveedor editar(Proveedor obj) {
        try {
            
            if (proveedorRepositorio.existsById(obj.getIdProveedor())) {
                return proveedorRepositorio.save(obj); // Guarda o actualiza el objeto
            } else {
                throw new RuntimeException("Proveedor no encontrada para actualizar");
            }
        } catch (Exception e) {
            System.out.println("Error al editar: " + e.getMessage());
            throw new RuntimeException("Error al editar la clasificación", e);
        }
    }

    // Método para eliminar
    public void eliminar(Long idProveedor) {
        try {
            if (proveedorRepositorio.existsById(idProveedor)) {
                proveedorRepositorio.deleteById(idProveedor); // Elimina el objeto
            } else {
                throw new RuntimeException("Proveedor no encontrada para eliminar");
            }
        } catch (Exception e) {
          
            System.out.println("Error al eliminar: " + e.getMessage());
            throw new RuntimeException("Error al eliminar la clasificación", e);
        }
    } 

    public List<Proveedor> listar() {
        try {
            return proveedorRepositorio.findAll();
        } catch (Exception e) {
            System.out.println("Error al listar los Proveedor: " + e.getMessage());
            throw new RuntimeException("Error al listar los Proveedor", e);
        }
    }
}
