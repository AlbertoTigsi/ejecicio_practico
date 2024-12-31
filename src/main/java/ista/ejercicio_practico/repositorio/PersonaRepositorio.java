package ista.ejercicio_practico.repositorio;

import ista.ejercicio_practico.modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Long> {

      @Query("SELECT a FROM Persona a WHERE  a.dni = :dni ")
        public Persona consultarPorDni(@Param("dni") String dni);
}
