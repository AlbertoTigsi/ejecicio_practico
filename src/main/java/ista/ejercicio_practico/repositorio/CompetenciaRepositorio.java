package ista.ejercicio_practico.repositorio;

import ista.ejercicio_practico.modelo.Competencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenciaRepositorio  extends JpaRepository<Competencia, Long>  {
    
}
