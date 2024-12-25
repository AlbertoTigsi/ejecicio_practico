package ista.ejercicio_practico.servicio;
import ista.ejercicio_practico.modelo.Factura;
import ista.ejercicio_practico.repositorio.FacturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FacturaServicio {

    @Autowired
    FacturaRepositorio facturaRepositorio;

    public Factura insertar(Factura obj) {
        try {
            return facturaRepositorio.save(obj);
        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
            throw new RuntimeException("Error al insertar la clasificación", e);
        }
    }

     // Método para editar (actualizar)
     public Factura editar(Factura obj) {
        try {
            
            if (facturaRepositorio.existsById(obj.getIdFactura())) {
                return facturaRepositorio.save(obj); // Guarda o actualiza el objeto
            } else {
                throw new RuntimeException("Factura no encontrada para actualizar");
            }
        } catch (Exception e) {
            System.out.println("Error al editar: " + e.getMessage());
            throw new RuntimeException("Error al editar la clasificación", e);
        }
    }

    // Método para eliminar
    public void eliminar(Long idFactura) {
        try {
            if (facturaRepositorio.existsById(idFactura)) {
                facturaRepositorio.deleteById(idFactura); // Elimina el objeto
            } else {
                throw new RuntimeException("Factura no encontrada para eliminar");
            }
        } catch (Exception e) {
          
            System.out.println("Error al eliminar: " + e.getMessage());
            throw new RuntimeException("Error al eliminar la clasificación", e);
        }
    } 
}
