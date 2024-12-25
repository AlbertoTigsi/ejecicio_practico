package ista.ejercicio_practico.repositorio;

import ista.ejercicio_practico.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
    
}
