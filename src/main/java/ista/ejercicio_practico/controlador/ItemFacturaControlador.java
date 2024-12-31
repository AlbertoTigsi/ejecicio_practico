package ista.ejercicio_practico.controlador;

import ista.ejercicio_practico.modelo.ItemFactura;
import ista.ejercicio_practico.servicio.ItemFacturaServicio;

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
@RequestMapping("/itemFactura")
@CrossOrigin(origins = "*")
public class ItemFacturaControlador {
    @Autowired
    ItemFacturaServicio itemFacturaServicio;
   
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    @ResponseBody
    public ItemFactura insertar(@RequestBody ItemFactura obj) {
       
            ItemFactura itemFacturaGuardada = itemFacturaServicio.insertar(obj);

            return itemFacturaGuardada;
    }
  

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/editar", method = RequestMethod.PUT)
    @ResponseBody
    public ItemFactura editar(@RequestBody ItemFactura obj) {
       
            ItemFactura itemFacturaGuardada = itemFacturaServicio.editar(obj);

            return itemFacturaGuardada;
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void eliminar(@PathVariable Long id) {
       
          itemFacturaServicio.eliminar(id);   
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    @ResponseBody
    public List<ItemFactura> listar() {
       
          return itemFacturaServicio.listar();   
    }

}
