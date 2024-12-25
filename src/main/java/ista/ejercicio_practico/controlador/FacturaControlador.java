package ista.ejercicio_practico.controlador;

import ista.ejercicio_practico.modelo.Factura;
import ista.ejercicio_practico.servicio.FacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/factura")
@CrossOrigin(origins = "*")
public class FacturaControlador {
    

    @Autowired
    FacturaServicio facturaServicio;
   
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    @ResponseBody
    public Factura insertar(@RequestBody Factura obj) {
       
            Factura facturaGuardada = facturaServicio.insertar(obj);

            return facturaGuardada;
    }
  

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/editar", method = RequestMethod.PUT)
    @ResponseBody
    public Factura editar(@RequestBody Factura obj) {
       
            Factura facturaGuardada = facturaServicio.editar(obj);

            return facturaGuardada;
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void eliminar(@PathVariable Long id) {
       
          facturaServicio.eliminar(id);   
    }
}
