package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import ar.edu.unju.fi.listas.ListaConsejos;
import ar.edu.unju.fi.listas.ListaServicios;
import ar.edu.unju.fi.model.Consejo;
import ar.edu.unju.fi.model.Servicio;

@Controller
@RequestMapping("/servicios")
public class ServicioController {
	
	@Autowired
	ListaServicios listaServicios;
 
	@Autowired
	private Servicio servicio;
	
@GetMapping("/listado")
public String getServiciosPage(Model model) {
	model.addAttribute("servicios", listaServicios.getServicios());
	return "serviciospaseo";
}
} 
