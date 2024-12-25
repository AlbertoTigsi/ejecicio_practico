package ista.ejercicio_practico.controlador;

import ista.ejercicio_practico.modelo.Producto;
import ista.ejercicio_practico.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*")
public class ProductoControlador {

    @Autowired
    ProductoServicio productoServicio;
   
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    @ResponseBody
    public Producto insertar(@RequestBody Producto obj) {
       
            Producto productoGuardada = productoServicio.insertar(obj);

            return productoGuardada;
    }
  

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/editar", method = RequestMethod.PUT)
    @ResponseBody
    public Producto editar(@RequestBody Producto obj) {
       
            Producto productoGuardada = productoServicio.editar(obj);

            return productoGuardada;
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void eliminar(@PathVariable Long id) {
       
          productoServicio.eliminar(id);   
    }
}
