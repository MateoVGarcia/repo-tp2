package ar.edu.unju.fi.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;
import ar.edu.unju.fi.model.Producto;
import ar.edu.unju.fi.listaProducto.*;

@Controller
public class ProductosController {
	
	listaproductos Listaproductos = new listaproductos();
	
	
	@GetMapping("/productos/listado")
	public String getListaproductospage(Model model) {
		model.addAttribute("productosn", listaproductos.getProductos());
		return "productos";
	}
	
	
	
	@GetMapping("/productos/nuevo")
	public String getNuevoProductopage(Model model){
		boolean edicion = false;
		model.addAttribute("producto", new Producto());
		model.addAttribute("edicion", edicion);
		return "nuevo_producto";
	}
	
	
	@PostMapping("/productos/guardar")
	public ModelAndView getGuardarproductopage(@ModelAttribute("productos")Producto producto) {
		ModelAndView modelView = new ModelAndView("redirect:/productos/listado");
		listaproductos.getProductos().add(producto);
		modelView.addObject("productos", listaproductos.getProductos());
	return modelView;
	}
	
	
	
	@GetMapping("/productos/modificar/{nombre}")
	public String getModificarProductoPage(Model model, @PathVariable(value = "nombre") String nombre) {
	    Producto productoEncontrado = null;
	    boolean edicion = true;

	    for (Producto Produ : listaproductos.getProductos()) {
	        if (Produ.getNombre().equals(nombre)) {
	            productoEncontrado = Produ;
	            break;
	        }
	    }

	    model.addAttribute("producto", productoEncontrado);
	    model.addAttribute("edicion", edicion);

	    return "nuevo_producto";
	}

	
	
	@PostMapping("/productos/modificar")
	public String modificarProducto(@ModelAttribute("producto") Producto producto) {
	    for (Producto Produ : listaproductos.getProductos()) {
	        if (Produ.getNombre().equals(producto.getNombre())) {
	            Produ.setCodigo(producto.getCodigo());
	            Produ.setPrecio(producto.getPrecio());
	            Produ.setCategoria(producto.getCategoria());
	            Produ.setDescuento(producto.getDescuento());
	        }
	    }

	    return "redirect:/productos/listado";
	}
	
	
	
	@GetMapping("/productos/eliminar/{nombre}")
	public String eliminarPrtoducto(@PathVariable(value = "nombre") String nombre) {
	    for (Producto produ : listaproductos.getProductos()) {
	        if (produ.getNombre().equals(nombre)) {
	            listaproductos.getProductos().remove(produ);
	            break;
	        }
	    }

	    return "redirect:/productos/listado";
	}



}

	
