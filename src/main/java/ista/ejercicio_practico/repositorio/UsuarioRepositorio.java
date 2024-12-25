package ista.ejercicio_practico.repositorio;

import ista.ejercicio_practico.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>  {
    
}
