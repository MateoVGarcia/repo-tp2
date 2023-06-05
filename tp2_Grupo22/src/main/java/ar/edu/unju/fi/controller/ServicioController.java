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
import ar.edu.unju.fi.model.Consejo;
import ar.edu.unju.fi.model.Servicio;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/servicios")
public class ServicioController {
	
	@Autowired
	ListaServicios listaServicios;
 
	@Autowired
	private Servicio servicio;
	
	//Pagina con el listado de los consejos (Cada uno está separado por categoría con th:if)
@GetMapping("/listado")
public String getServiciosPage(Model model) {
	model.addAttribute("servicios", listaServicios.getServicios());
	return "servicios";
}


	//Pagina para crear un consejo nuevo
@GetMapping("/nuevo")
public String getNuevoPage(Model model) {
	boolean edicion = false ;
	model.addAttribute("servicio",servicio );
	model.addAttribute("edicion",edicion);
	return "nuevo_servicio";
}

@GetMapping("/modificar/{paseador}")
public String getModificarPage(Model model,@PathVariable(value="paseador")String pas){
	boolean edicion = true;
	Servicio servicioEncontrado = new Servicio();
	for(Servicio serv : listaServicios.getServicios()) {
		if(serv.getPaseador().equals(pas)) {
			servicioEncontrado = serv;
			break;
		}
	}
	
	model.addAttribute("servicio", servicioEncontrado);
	model.addAttribute("edicion",edicion);
	
	return "nuevo_servicio";	
}

@PostMapping("/modificar")
public String modificarConsejo(@ModelAttribute("servicio")Servicio servicio ) {
	for(Servicio serv: listaServicios.getServicios()) { 
		if(serv.getPaseador().equals(servicio.getPaseador())) {
			
			
			serv.setDia(servicio.getDia());
			serv.setPaseador(servicio.getPaseador());
			serv.setHorainicio(servicio.getHorainicio());
			serv.setHorafin(servicio.getHorafin());
		}
	}
	return "redirect:/servicios/listado";
}

	//Pagina de guardado de los consejos
@PostMapping("/guardar")
public ModelAndView getGuardarServiciosPage(@Valid @ModelAttribute("servicio")Servicio servicio, BindingResult result) {
	ModelAndView modelView = new ModelAndView("servicios");
	if(result.hasErrors()) {
		modelView.setViewName("nuevo_servicio");
		modelView.addObject("servicio", servicio);
		return modelView;
	}
	listaServicios.getServicios().add(servicio);
	modelView.addObject("servicios", listaServicios.getServicios());
	return modelView;
}

	//Pagina para eliminar consejos
@GetMapping("/eliminar/{paseador}")
public String eliminarServicio(@PathVariable(value="paseador") String pas) {
	for(Servicio serv: listaServicios.getServicios()) {
		if(serv.getPaseador().equals(pas)) {
			listaServicios.getServicios().remove(serv);
			break;
			
		}
	}
	
	 return"redirect:/servicios/listado";
}

} 
