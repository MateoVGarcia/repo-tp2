package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import ar.edu.unju.fi.listas.ListaServicios;
import ar.edu.unju.fi.model.Servicio;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/servicios")
public class ServicioController {
	
	@Autowired
	ListaServicios listaServicios;
 
	@Autowired
	private Servicio servicio;
	
	
	@GetMapping("")
	public String getServicioPage() {
		return "serviciospaseo";
	}
	
	@GetMapping("/listado")
	public String getServiciosPage(Model model) {
	model.addAttribute("servicios", listaServicios.getServicios());
	return "serviciospaseo";
	}
	
	
	@GetMapping("/nuevo")
	 public String getNuevoServicioPage(Model model) {
        boolean edicion = false;
        model.addAttribute("servicio", servicio);
        model.addAttribute("edicion", edicion);
        return "nuevo_servicio";
    }
	
	
	@PostMapping("/guardar")
	public ModelAndView postGuardarServicioPage(@Valid @ModelAttribute("servicios")Servicio servicio, BindingResult result) {
		 if (result.hasErrors()) {
			 ModelAndView modelView = new ModelAndView("nuevo_servicio");
		     return modelView;
		    }
		
		ModelAndView modelView = new ModelAndView("redirect:/servicios/listado");
		listaServicios.getServicios().add(servicio);
		modelView.addObject("servicios", listaServicios.getServicios());
		return modelView;
	}
	
	
	
	@GetMapping("/modificar/{paseador}")
	public String getModificarServicioPage(Model model, @PathVariable(value = "paseador") String paseador) {
	    Servicio servicioEncontrado = null;
	    boolean edicion = true;
	    for (Servicio serv : listaServicios.getServicios()){
	        if (serv.getPaseador().equals(paseador)) {
	            servicioEncontrado = serv;
	            break;
	        }
	    }

	    model.addAttribute("servicio", servicioEncontrado);
	    model.addAttribute("edicion", edicion);

	    return "nuevo_servicio";
	}
	
	
	
	
	@PostMapping("/modificar")
	public String postModificarServicioPage(@Valid @ModelAttribute("servicio") Servicio servicio, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "nuevo_servicio";
	    }
		
		for (Servicio serv  : listaServicios.getServicios()) {
	        if (serv.getPaseador().equals(servicio.getPaseador())) {
	        	serv.setDia(servicio.getDia());
	            serv.setHorainicio(servicio.getHorainicio());
	            serv.setHorafin(servicio.getHorafin());
	          
	        }
	    }

	    return "redirect:/servicios/listado";
	}
	
	
	@GetMapping("/eliminar/{paseador}")
	public String eliminarServicio(@PathVariable(value = "paseador") String paseador) {
	    for (Servicio serv : listaServicios.getServicios()) {
	        if (serv.getPaseador().equals(paseador)) {
	        	listaServicios.getServicios().remove(serv);
	            break;
	        }
	    }

	    return "redirect:/servicios/listado";
	}
	
} 
