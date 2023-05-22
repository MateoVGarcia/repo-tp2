package ar.edu.unju.fi.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;
import ar.edu.unju.fi.model.Producto;
import ar.edu.unju.fi.listaProducto.*;

@Controller
@RequestMapping("/productos")
public class ProductosController {
	
	listaproductos Listaproductos = new listaproductos();
	
	@GetMapping("/listado")
	public String getListaproductospage(Model model) {
		model.addAttribute("productosn", listaproductos.getProductos());
		return "productos";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoProductopage(Model model){
		boolean edicion = false;
		model.addAttribute("producto", new Producto(null, 0, 0, null, 0));
		model.addAttribute("Editar", edicion);
		return "nuevo_producto";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarproductopage(@ModelAttribute("producto")Producto productos) {
	ModelAndView modelView = new ModelAndView("productos");
	listaproductos.getProductos().add(productos);
	modelView.addObject("productos", listaproductos.getProductos());
	return modelView;
	}
	
	@GetMapping("/modificar/{nombre}")
	public String getModificarProductoPage(Model model, @PathVariable(value = "nombre") String nombre) {
	    Producto productoEncontrado = null;
	    boolean edicion = true;

	    for (Producto produ : listaproductos.getProductos()) {
	        if (produ.getNombre().equals(nombre)) {
	            productoEncontrado = produ;
	            break;
	        }
	    }

	    model.addAttribute("productos", productoEncontrado);
	    model.addAttribute("EDITAR", edicion);

	    return "nuevo_producto";
	}

	@PostMapping("/modificar")
	public String modificarProducto(@ModelAttribute("producto") Producto productos) {
	    for (Producto produ : listaproductos.getProductos()) {
	        if (produ.getNombre().equals(productos.getNombre())) {
	            produ.setCodigo(productos.getCodigo());
	            produ.setPrecio(productos.getPrecio());
	            produ.setCategoria(productos.getCategoria());
	            produ.setDescuento(productos.getDescuento());
	            break;
	        }
	    }

	    return "redirect:/productos/listado";
	}
	
	@GetMapping("/eliminar/{nombre}")
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

	
