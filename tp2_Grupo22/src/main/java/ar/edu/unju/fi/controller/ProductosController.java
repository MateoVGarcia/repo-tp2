package ar.edu.unju.fi.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;

import ar.edu.unju.fi.listas.*;
import ar.edu.unju.fi.model.Producto;

@Controller
@RequestMapping("/productos")

public class ProductosController {
	

	//Se muestra el listado de productos
	@GetMapping("/listado")
	public String getListaproductospage(Model model) {
		model.addAttribute("productos", listaproductos.getProductos());
		return "productos";
	}
	
	//Agregar nuevo producto
	  @GetMapping("/nuevo")
	    public String mostrarFormularioNuevo(Model model) {
		  boolean edicion=false;
	        model.addAttribute("producto", new Producto());
	    	model.addAttribute("edicion", edicion);
	        return "nuevo_producto";
	    }

	  //Guardar, se usa en caso de editar o de agregar un nuevo producto
	    @PostMapping("/guardar")
	    public String guardarProducto(@ModelAttribute("producto") Producto producto) {
	        ModelAndView modelView= new ModelAndView("productos");
	    	listaproductos.setProductos(producto);
	    	modelView.addObject("productos", listaproductos.getProductos());
	        return "redirect:/productos/listado";
	    }
	    
	    //Modificar producto
	    @GetMapping("/modificar/{codigo}")
	    public String getModificarProductosPage(Model model, @PathVariable(value="codigo")int codigo) {
	    	Producto productoModificar = new Producto();
	    	boolean edicion = true;
	    	for(Producto produ : listaproductos.getProductos()) {
	    		if(produ.getCodigo() == (codigo)) {
	    			productoModificar = produ;
	    			break;
	    	}
	    }
	    	model.addAttribute("producto", productoModificar);
	    	model.addAttribute("edicion", edicion);
	    	
	    	return "nuevo_producto";
	    }

        // Eliminar el producto de la lista
	@GetMapping("/eliminar/{id}")
	public String eliminarPrtoducto(@PathVariable int id) {
        Producto productoEliminado = null;
        
        for (Producto producto : listaproductos.getProductos()) {
            if (producto.getCodigo() == id) {
                productoEliminado = producto;
                break;
            }
        }
	
        if (productoEliminado != null) {
            listaproductos.getProductos().remove(productoEliminado);
        }
        
        return "redirect:/productos/listado";
    }
}



	
