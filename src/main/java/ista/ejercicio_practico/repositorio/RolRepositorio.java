package ista.ejercicio_practico.repositorio;

import ista.ejercicio_practico.modelo.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RolRepositorio  extends JpaRepository<Rol, Long> {
    
}
