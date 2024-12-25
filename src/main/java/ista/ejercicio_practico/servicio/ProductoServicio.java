package ista.ejercicio_practico.servicio;
import ista.ejercicio_practico.modelo.Producto;
import ista.ejercicio_practico.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductoServicio {

    @Autowired
    ProductoRepositorio productoRepositorio;

    public Producto insertar(Producto obj) {
        try {
            return productoRepositorio.save(obj);
        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
            throw new RuntimeException("Error al insertar la clasificación", e);
        }
    }

     // Método para editar (actualizar)
     public Producto editar(Producto obj) {
        try {
            
            if (productoRepositorio.existsById(obj.getIdProducto())) {
                return productoRepositorio.save(obj); // Guarda o actualiza el objeto
            } else {
                throw new RuntimeException("Producto no encontrada para actualizar");
            }
        } catch (Exception e) {
            System.out.println("Error al editar: " + e.getMessage());
            throw new RuntimeException("Error al editar la clasificación", e);
        }
    }

    // Método para eliminar
    public void eliminar(Long idProducto) {
        try {
            if (productoRepositorio.existsById(idProducto)) {
                productoRepositorio.deleteById(idProducto); // Elimina el objeto
            } else {
                throw new RuntimeException("Producto no encontrada para eliminar");
            }
        } catch (Exception e) {
          
            System.out.println("Error al eliminar: " + e.getMessage());
            throw new RuntimeException("Error al eliminar la clasificación", e);
        }
    } 
}
