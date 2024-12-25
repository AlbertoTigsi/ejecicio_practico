package ista.ejercicio_practico.servicio;
import ista.ejercicio_practico.modelo.ItemFactura;
import ista.ejercicio_practico.repositorio.ItemFacturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemFacturaServicio {

    @Autowired
    ItemFacturaRepositorio itemFacturaRepositorio;

    public ItemFactura insertar(ItemFactura obj) {
        try {
            return itemFacturaRepositorio.save(obj);
        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
            throw new RuntimeException("Error al insertar la clasificación", e);
        }
    }

     // Método para editar (actualizar)
     public ItemFactura editar(ItemFactura obj) {
        try {
            
            if (itemFacturaRepositorio.existsById(obj.getIdItemFactura())) {
                return itemFacturaRepositorio.save(obj); // Guarda o actualiza el objeto
            } else {
                throw new RuntimeException("ItemFactura no encontrada para actualizar");
            }
        } catch (Exception e) {
            System.out.println("Error al editar: " + e.getMessage());
            throw new RuntimeException("Error al editar la clasificación", e);
        }
    }

    // Método para eliminar
    public void eliminar(Long idFactura) {
        try {
            if (itemFacturaRepositorio.existsById(idFactura)) {
                itemFacturaRepositorio.deleteById(idFactura); // Elimina el objeto
            } else {
                throw new RuntimeException("ItemFactura no encontrada para eliminar");
            }
        } catch (Exception e) {
          
            System.out.println("Error al eliminar: " + e.getMessage());
            throw new RuntimeException("Error al eliminar la clasificación", e);
        }
    } 
}
