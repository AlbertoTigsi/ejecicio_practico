package ista.ejercicio_practico.controlador;

import ista.ejercicio_practico.modelo.Clasificacion;
import ista.ejercicio_practico.servicio.ClasificacionServicio;

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
@RequestMapping("/clasificacion")
@CrossOrigin(origins = "*")
public class ClasificacionControlador {

    @Autowired
    ClasificacionServicio clasificacionServicio;
   
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    @ResponseBody
    public Clasificacion insertar(@RequestBody Clasificacion obj) {
       
            Clasificacion clasificacionGuardada = clasificacionServicio.insertar(obj);

            return clasificacionGuardada;
    }
  

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/editar", method = RequestMethod.PUT)
    @ResponseBody
    public Clasificacion editar(@RequestBody Clasificacion obj) {
       
            Clasificacion clasificacionGuardada = clasificacionServicio.editar(obj);

            return clasificacionGuardada;
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void eliminar(@PathVariable Long id) {
       
          clasificacionServicio.eliminar(id);   
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    @ResponseBody
    public List<Clasificacion> listar() {
       
          return clasificacionServicio.listar();   
    }

  
}
