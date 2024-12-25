package ista.ejercicio_practico.repositorio;

import ista.ejercicio_practico.modelo.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepositorio extends JpaRepository<Factura, Long>  {
    
}
