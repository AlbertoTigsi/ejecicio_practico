package ista.ejercicio_practico.servicio;
import ista.ejercicio_practico.modelo.TipoPago;
import ista.ejercicio_practico.repositorio.TipoPagoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TipoPagoServicio {

    @Autowired
    TipoPagoRepositorio tipoPagoRepositorio;

    public TipoPago insertar(TipoPago obj) {
        try {
            if (obj.getIdTipoPago() != null && tipoPagoRepositorio.existsById(obj.getIdTipoPago())) {
                throw new IllegalArgumentException("El tipo de pago con ID " + obj.getIdTipoPago() + " ya existe.");
            }
            return tipoPagoRepositorio.save(obj);
        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
            throw new RuntimeException("Error al insertar la tipo pago", e);
        }
    }

     // Método para editar (actualizar)
     public TipoPago editar(TipoPago obj) {
        try {
            
            if (tipoPagoRepositorio.existsById(obj.getIdTipoPago())) {
                return tipoPagoRepositorio.save(obj); // Guarda o actualiza el objeto
            } else {
                throw new RuntimeException("TipoPago no encontrada para actualizar");
            }
        } catch (Exception e) {
            System.out.println("Error al editar: " + e.getMessage());
            throw new RuntimeException("Error al editar la clasificación", e);
        }
    }

    // Método para eliminar
    public void eliminar(Long idTipoPago) {
        try {
            if (tipoPagoRepositorio.existsById(idTipoPago)) {
                tipoPagoRepositorio.deleteById(idTipoPago); // Elimina el objeto
            } else {
                throw new RuntimeException("TipoPago no encontrada para eliminar");
            }
        } catch (Exception e) {
          
            System.out.println("Error al eliminar: " + e.getMessage());
            throw new RuntimeException("Error al eliminar la clasificación", e);
        }
    } 
}
