package ista.ejercicio_practico.controlador;

import ista.ejercicio_practico.modelo.Usuario;
import ista.ejercicio_practico.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioControlador {

    @Autowired
    UsuarioServicio usuarioServicio;
   
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    @ResponseBody
    public Usuario insertar(@RequestBody Usuario obj) {
       
            Usuario usuarioGuardada = usuarioServicio.insertar(obj);

            return usuarioGuardada;
    }
  

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/editar", method = RequestMethod.PUT)
    @ResponseBody
    public Usuario editar(@RequestBody Usuario obj) {
       
            Usuario usuarioGuardada = usuarioServicio.editar(obj);

            return usuarioGuardada;
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void eliminar(@PathVariable Long id) {
       
          usuarioServicio.eliminar(id);   
    }
}
