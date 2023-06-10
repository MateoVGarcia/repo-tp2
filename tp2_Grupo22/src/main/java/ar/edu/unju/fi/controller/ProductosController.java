package ar.edu.unju.fi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;
import ar.edu.unju.fi.model.Producto;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/productos")
public class ProductosController {
	
	@Autowired
	private IProductoService productoService;
	

	
	//Pagina con el listado de los productgos 
@GetMapping("/listado")
public String getProductosPage(Model model) {
	model.addAttribute("productos", productoService.getListaP());
	return "productos";
}


	//Pagina para crear un producto nuevo
@GetMapping("/nuevo")
public String getNuevoProductoPage(Model model) {
    boolean edicion = false ;
    Producto producto = new Producto(); // Crear un nuevo objeto Producto
    model.addAttribute("producto", producto);
    model.addAttribute("edicion", edicion);
    return "nuevo_producto";
}

//Página para modificar un producto
@GetMapping("/modificar/{codigo}")
public String getModificarProductosPage(Model model, @PathVariable(value = "codigo") int cod) {
    boolean edicion = true;
    Producto productoEncontrado = productoService.eliminarProducto(cod);
    if (productoEncontrado == null) {
        return "redirect:/productos/listado";
    }
    model.addAttribute("producto", productoEncontrado);
    model.addAttribute("edicion", edicion);
    return "nuevo_producto";
}


@PostMapping("/modificar")
public String modificarProducto(@ModelAttribute("producto") Producto producto) {
    productoService.modificarProducto(producto);
    return "redirect:/productos/listado";
}

//Método para guardar o modificar un producto
@PostMapping("/guardar")
public ModelAndView guardarProducto(@Valid @ModelAttribute("producto") Producto producto, BindingResult result) {
    ModelAndView modelView = new ModelAndView("productos");
    if (result.hasErrors()) {
        modelView.setViewName("nuevo_producto");
        modelView.addObject("producto", producto);
        return modelView;
    }
    productoService.guardarProducto(producto);
    modelView.addObject("productos", productoService.getListaP());
    return modelView;
}

//Página para eliminar un producto
@GetMapping("/eliminar/{codigo}")
public String eliminarProducto(@PathVariable(value = "codigo") int cod) {
    productoService.eliminarProducto(cod);
    return "redirect:/productos/listado";
}
}
