package ista.ejercicio_practico.controlador;

import ista.ejercicio_practico.modelo.Competencia;
import ista.ejercicio_practico.servicio.CompetenciaServicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/competencia")
@CrossOrigin(origins = "*")
public class CompetenciaControlador {
    

    @Autowired
    CompetenciaServicio competenciaServicio;
   
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    @ResponseBody
    public Competencia insertar(@RequestBody Competencia obj) {
       
            Competencia competenciaGuardada = competenciaServicio.insertar(obj);

            return competenciaGuardada;
    }
  

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/editar", method = RequestMethod.PUT)
    @ResponseBody
    public Competencia editar(@RequestBody Competencia obj) {
       
            Competencia competenciaGuardada = competenciaServicio.editar(obj);

            return competenciaGuardada;
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void eliminar(@PathVariable Long id) {
       
          competenciaServicio.eliminar(id);   
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    @ResponseBody
    public List<Competencia> listar() {
       
          return competenciaServicio.listar();   
    }

}
