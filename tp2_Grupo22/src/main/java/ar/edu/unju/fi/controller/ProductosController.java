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
	

	
	@GetMapping("/listado")
	public String getListaproductospage(Model model) {
		model.addAttribute("productos", listaproductos.getProductos());
		return "productos";
	}
	  @GetMapping("/nuevo")
	    public String mostrarFormularioNuevo(Model model) {
	        model.addAttribute("producto", new Producto());
	        return "nuevo_producto";
	    }

	    @PostMapping("/guardar")
	    public ModelAndView guardarProducto(@ModelAttribute("producto") Producto producto) {
	        ModelAndView modelView= new ModelAndView("productos");
	    	listaproductos.setProductos(producto);
	    	modelView.addObject("productos", listaproductos.getProductos());
	        return modelView;
	    }


	@GetMapping("/eliminar/{id}")
	public String eliminarPrtoducto(@PathVariable int id) {
        // Lógica para eliminar el producto de la lista
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



	
