package ista.ejercicio_practico.repositorio;

import ista.ejercicio_practico.modelo.Clasificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasificacionRepositorio extends JpaRepository<Clasificacion, Long> {
    
}
