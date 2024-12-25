package ista.ejercicio_practico.servicio;
import ista.ejercicio_practico.modelo.Persona;
import ista.ejercicio_practico.repositorio.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonaServicio {
    
    @Autowired
    PersonaRepositorio personaRepositorio;

    public Persona insertar(Persona obj) {
        try {
            return personaRepositorio.save(obj);
        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
            throw new RuntimeException("Error al insertar la clasificación", e);
        }
    }

     // Método para editar (actualizar)
     public Persona editar(Persona obj) {
        try {
            
            if (personaRepositorio.existsById(obj.getIdPersona())) {
                return personaRepositorio.save(obj); // Guarda o actualiza el objeto
            } else {
                throw new RuntimeException("Persona no encontrada para actualizar");
            }
        } catch (Exception e) {
            System.out.println("Error al editar: " + e.getMessage());
            throw new RuntimeException("Error al editar la clasificación", e);
        }
    }

    // Método para eliminar
    public void eliminar(Long idPersona) {
        try {
            if (personaRepositorio.existsById(idPersona)) {
                personaRepositorio.deleteById(idPersona); // Elimina el objeto
            } else {
                throw new RuntimeException("Persona no encontrada para eliminar");
            }
        } catch (Exception e) {
          
            System.out.println("Error al eliminar: " + e.getMessage());
            throw new RuntimeException("Error al eliminar la clasificación", e);
        }
    } 
}
