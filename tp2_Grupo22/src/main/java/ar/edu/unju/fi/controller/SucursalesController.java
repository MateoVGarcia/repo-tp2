package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.model.Sucursal;

@Controller
@RequestMapping("/sucursal")
public class SucursalesController{
	
	ListaSucursal listaSucursales = new ListaSucursal();
	
	
	@GetMapping ("/listado")
		public String getSgetListasucursalesPage(Model model) {
			model.addAttribute("sucursales", listaSucursales.getSucursales());
			return "sucursales";
	}
	
	@GetMapping ("/nuevo")
	public String getNuevaSucursalPage(Model model) {
		model.addAttribute("sucursales", new Sucursal());
		return "nuevasucursal";
	}
	
	@GetMapping ("/guardar")
	public ModelAndView getGuardarSucursalPage(@ModelAttribute("sucursal")Sucursal sucursal) {
		ModelAndView modelView = new ModelAndView("sucursales");
		listaSucursales.getSucursales().add(sucursal);
		modelView.addObject("sucursales",listaSucursales.getSucursales());
		return modelView;
	
	}
	
}
