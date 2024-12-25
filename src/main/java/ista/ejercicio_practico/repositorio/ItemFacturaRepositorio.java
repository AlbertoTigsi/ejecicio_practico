package ista.ejercicio_practico.repositorio;

import ista.ejercicio_practico.modelo.ItemFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemFacturaRepositorio extends JpaRepository<ItemFactura, Long> {
    
}
