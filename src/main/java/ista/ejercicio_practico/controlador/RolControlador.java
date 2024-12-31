package ista.ejercicio_practico.controlador;

import ista.ejercicio_practico.modelo.Rol;
import ista.ejercicio_practico.servicio.RolServicio;

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
@RequestMapping("/rol")
@CrossOrigin(origins = "*")
public class RolControlador {
    
    @Autowired
    RolServicio rolServicio;
   
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    @ResponseBody
    public Rol insertar(@RequestBody Rol obj) {
       
            Rol rolGuardada = rolServicio.insertar(obj);

            return rolGuardada;
    }
  

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/editar", method = RequestMethod.PUT)
    @ResponseBody
    public Rol editar(@RequestBody Rol obj) {
       
            Rol rolGuardada = rolServicio.editar(obj);

            return rolGuardada;
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void eliminar(@PathVariable Long id) {
       
          rolServicio.eliminar(id);   
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    @ResponseBody
    public List<Rol> listar() {
       
          return rolServicio.listar();   
    }

}
