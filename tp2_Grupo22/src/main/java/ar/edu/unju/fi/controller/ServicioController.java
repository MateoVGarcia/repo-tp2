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

import ar.edu.unju.fi.model.Servicio;
import ar.edu.unju.fi.service.IServicioService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/servicios")
public class ServicioController {
	
	@Autowired
	private IServicioService servicioService;
 

// Método para obtener la página de listado de servicios
@GetMapping("/listado")
public String getServiciosPage(Model model) {
	model.addAttribute("servicios", servicioService.getListaServicio());
	return "servicios";
}



//Método para obtener la página de creación de un nuevo servicio
@GetMapping("/nuevo")
public String getNuevoPage(Model model) {
	boolean edicion = false ;
	model.addAttribute("servicio", servicioService.getServicio());
	model.addAttribute("edicion",edicion);
	return "nuevo_servicio";
}



//Método para obtener la página de modificación de un servicio existente
@GetMapping("/modificar/{paseador}")
public String getModificarPage(Model model,@PathVariable(value="paseador")String pas){
	Servicio servicioEncontrado = servicioService.getBy(pas);
	boolean edicion = true;
	model.addAttribute("servicio", servicioEncontrado);
	model.addAttribute("edicion",edicion);	
	return "nuevo_servicio";	
}



//Método para procesar la modificación de un servicio
@PostMapping("/modificar")
public String modificarServicio(@ModelAttribute("servicio") @Valid Servicio servicio, BindingResult result ) {
	 if (result.hasErrors()) {
		 return "nuevo_servicio";
	  }
	servicioService.modificarServicio(servicio);
	return "redirect:/servicios/listado";
}

	

// Método para guardar un nuevo servicio
@PostMapping("/guardar")
public ModelAndView getGuardarServiciosPage(@Valid @ModelAttribute("servicio")Servicio servicio, BindingResult result) {
	ModelAndView modelView = new ModelAndView("servicios");
	if(result.hasErrors()) {
		modelView.setViewName("nuevo_servicio");
		modelView.addObject("servicio", servicio);
		return modelView;
	}
	servicioService.guardarServicio(servicio);
	modelView.addObject("servicios", servicioService.getListaServicio());
	return modelView;
}



//Método para eliminar un servicio
@GetMapping("/eliminar/{paseador}")
public String eliminarServicio(@PathVariable(value="paseador") String pas) {
	Servicio servicioEncontrado = servicioService.getBy(pas); 
	servicioService.eliminarServicio(servicioEncontrado);
	 return"redirect:/servicios/listado";
}

} 
