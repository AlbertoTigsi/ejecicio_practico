package ista.ejercicio_practico.controlador;

import ista.ejercicio_practico.modelo.Persona;
import ista.ejercicio_practico.servicio.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "*")
public class PersonaControlador {
    
    @Autowired
    PersonaServicio personaServicio;
   
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    @ResponseBody
    public Persona insertar(@RequestBody Persona obj) {
       
            Persona personaGuardada = personaServicio.insertar(obj);

            return personaGuardada;
    }
  

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/editar", method = RequestMethod.PUT)
    @ResponseBody
    public Persona editar(@RequestBody Persona obj) {
       
            Persona personaGuardada = personaServicio.editar(obj);

            return personaGuardada;
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void eliminar(@PathVariable Long id) {
       
          personaServicio.eliminar(id);   
    } 
}
