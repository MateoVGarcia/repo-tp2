package ar.edu.unju.fi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;

import ar.edu.unju.fi.listaProducto.ListaProductos;
import ar.edu.unju.fi.model.Producto;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/productos")
public class ProductosController {
	
	@Autowired
	private Producto producto;
	
	@Autowired 
	private  ListaProductos listaProductos;

	
	//Pagina con el listado de los productgos 
@GetMapping("/listado")
public String getProductosPage(Model model) {
	model.addAttribute("productos", listaProductos.getProductos());
	return "productos";
}


	//Pagina para crear un producto nuevo
@GetMapping("/nuevo")
public String getNuevoProductoPage(Model model) {
	boolean edicion = false ;
	model.addAttribute("producto", producto);
	model.addAttribute("edicion",edicion);
	return "nuevo_producto";
}

@GetMapping("/modificar/{codigo}")
public String getModificarProductosPage(Model model,@PathVariable(value="codigo")String cod){
	boolean edicion = true;
	Producto productoEncontrado = producto;
	for(Producto prod : listaProductos.getProductos()) {
		if(prod.getCategoria().equals(cod)) {
			productoEncontrado = prod;
			break;
		}
	}
	
	model.addAttribute("producto", productoEncontrado);
	model.addAttribute("edicion",edicion);
	
	return "nuevo_producto";	
}

@PostMapping("/modificar")
public String modificarProducto(@ModelAttribute("producto")Producto producto) {
	for(Producto prod: listaProductos.getProductos()) { 
		if(prod.getCodigo()==(producto.getCodigo())) {
			
			
			prod.setNombre(producto.getNombre());
			prod.setCodigo(producto.getCodigo());
			prod.setPrecio(producto.getPrecio());
			prod.setCategoria(producto.getCategoria());
			prod.setDescuento(producto.getDescuento());
		}
	}
	return "redirect:/productos/listado";
}

	//Pagina de guardado de los productos
@PostMapping("/guardar")
public ModelAndView getGuardarProductoPage(@Valid @ModelAttribute("producto")Producto producto, BindingResult result) {
	ModelAndView modelView = new ModelAndView("productos");
	if(result.hasErrors()) {
		modelView.setViewName("nuevo_producto");
		modelView.addObject("producto", producto);
		return modelView;
	}
	listaProductos.getProductos().add(producto);
	modelView.addObject("productos", listaProductos.getProductos());
	return modelView;
}

	//Pagina para eliminar producto
@GetMapping("/eliminar/{codigo}")
public String eliminarProducto(@PathVariable(value="codigo") int cod) {
	for(Producto prod: listaProductos.getProductos()) {
		if(prod.getCodigo()==(cod)) {
			listaProductos.getProductos().remove(prod);
			break;
			
		}
	}
	
	 return"redirect:/productos/listado";
}

}




	
