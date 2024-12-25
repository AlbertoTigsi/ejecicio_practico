package ista.ejercicio_practico.repositorio;

import ista.ejercicio_practico.modelo.TipoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TipoPagoRepositorio extends JpaRepository<TipoPago, Long> {
    
}
