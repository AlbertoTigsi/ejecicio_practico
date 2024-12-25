package ista.ejercicio_practico.repositorio;

import ista.ejercicio_practico.modelo.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor, Long> {
    
}
