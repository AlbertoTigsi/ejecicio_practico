package ista.ejercicio_practico.controlador;

import ista.ejercicio_practico.modelo.TipoPago;
import ista.ejercicio_practico.servicio.TipoPagoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/tipoPago")
@CrossOrigin(origins = "*")
public class TipoPagoControlador {

    @Autowired
    TipoPagoServicio tipoPagoServicio;
   
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    @ResponseBody
    public TipoPago insertar(@RequestBody TipoPago obj) {
       
            TipoPago tipoPagoGuardada = tipoPagoServicio.insertar(obj);

            return tipoPagoGuardada;
    }
  

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/editar", method = RequestMethod.PUT)
    @ResponseBody
    public TipoPago editar(@RequestBody TipoPago obj) {
       
            TipoPago tipoPagoGuardada = tipoPagoServicio.editar(obj);

            return tipoPagoGuardada;
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void eliminar(@PathVariable Long id) {
       
          tipoPagoServicio.eliminar(id);   
    }
}
