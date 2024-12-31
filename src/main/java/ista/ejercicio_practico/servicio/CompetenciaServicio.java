package ista.ejercicio_practico.servicio;
import ista.ejercicio_practico.modelo.Clasificacion;
import ista.ejercicio_practico.modelo.Competencia;
import ista.ejercicio_practico.repositorio.CompetenciaRepositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CompetenciaServicio {
    
    @Autowired
    CompetenciaRepositorio competenciaRepositorio;

    public Competencia insertar(Competencia obj) {
        try {
            return competenciaRepositorio.save(obj);
        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
            throw new RuntimeException("Error al insertar la clasificación", e);
        }
    }

     // Método para editar (actualizar)
     public Competencia editar(Competencia obj) {
        try {
            
            if (competenciaRepositorio.existsById(obj.getIdCompetencia())) {
                return competenciaRepositorio.save(obj); // Guarda o actualiza el objeto
            } else {
                throw new RuntimeException("Competencia no encontrada para actualizar");
            }
        } catch (Exception e) {
            System.out.println("Error al editar: " + e.getMessage());
            throw new RuntimeException("Error al editar la clasificación", e);
        }
    }

    // Método para eliminar
    public void eliminar(Long idCompetencia) {
        try {
            if (competenciaRepositorio.existsById(idCompetencia)) {
                competenciaRepositorio.deleteById(idCompetencia); // Elimina el objeto
            } else {
                throw new RuntimeException("Competencia no encontrada para eliminar");
            }
        } catch (Exception e) {
          
            System.out.println("Error al eliminar: " + e.getMessage());
            throw new RuntimeException("Error al eliminar la clasificación", e);
        }
    }
    public List<Competencia> listar() {
        try {
            return competenciaRepositorio.findAll();
        } catch (Exception e) {
            System.out.println("Error al listar los Competencia: " + e.getMessage());
            throw new RuntimeException("Error al listar los Competencia", e);
        }
    }
    
}
