package ista.ejercicio_practico.servicio;
import ista.ejercicio_practico.modelo.Usuario;
import ista.ejercicio_practico.repositorio.UsuarioRepositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServicio {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    public Usuario insertar(Usuario obj) {
        try {
            return usuarioRepositorio.save(obj);
        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
            throw new RuntimeException("Error al insertar la clasificación", e);
        }
    }

     // Método para editar (actualizar)
     public Usuario editar(Usuario obj) {
        try {
            
            if (usuarioRepositorio.existsById(obj.getIdUsuario())) {
                return usuarioRepositorio.save(obj); // Guarda o actualiza el objeto
            } else {
                throw new RuntimeException("Usuario no encontrada para actualizar");
            }
        } catch (Exception e) {
            System.out.println("Error al editar: " + e.getMessage());
            throw new RuntimeException("Error al editar la clasificación", e);
        }
    }

    // Método para eliminar
    public void eliminar(Long idUsuario) {
        try {
            if (usuarioRepositorio.existsById(idUsuario)) {
                usuarioRepositorio.deleteById(idUsuario); // Elimina el objeto
            } else {
                throw new RuntimeException("Usuario no encontrada para eliminar");
            }
        } catch (Exception e) {
          
            System.out.println("Error al eliminar: " + e.getMessage());
            throw new RuntimeException("Error al eliminar la clasificación", e);
        }
    } 

    public List<Usuario> listar() {
        try {
            return usuarioRepositorio.findAll();
        } catch (Exception e) {
            System.out.println("Error al listar los Usuarios: " + e.getMessage());
            throw new RuntimeException("Error al listar los Usuarios", e);
        }
    }
}
