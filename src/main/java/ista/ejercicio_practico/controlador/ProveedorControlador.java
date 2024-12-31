package ista.ejercicio_practico.controlador;

import ista.ejercicio_practico.modelo.Proveedor;
import ista.ejercicio_practico.servicio.ProveedorServicio;

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
@RequestMapping("/proveedor")
@CrossOrigin(origins = "*")
public class ProveedorControlador {
    
    @Autowired
    ProveedorServicio proveedorServicio;
   
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    @ResponseBody
    public Proveedor insertar(@RequestBody Proveedor obj) {
       
            Proveedor proveedorGuardada = proveedorServicio.insertar(obj);

            return proveedorGuardada;
    }
  

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/editar", method = RequestMethod.PUT)
    @ResponseBody
    public Proveedor editar(@RequestBody Proveedor obj) {
       
            Proveedor proveedorGuardada = proveedorServicio.editar(obj);

            return proveedorGuardada;
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void eliminar(@PathVariable Long id) {
       
          proveedorServicio.eliminar(id);   
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    @ResponseBody
    public List<Proveedor> listar() {
       
          return proveedorServicio.listar();   
    }

}
