package ar.edu.unju.fi.controller;
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaSucursales;
import ar.edu.unju.fi.model.FormSucursal;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/sucursales")
	public class SucursalController{
	
	@Autowired
	private ListaSucursales listaSucursales;
	
	@Autowired
	private FormSucursal sucursal;
	
	@GetMapping("/listado")
	public String getListaSucursalesPage(Model model) {
		model.addAttribute("sucursales", listaSucursales.getSucursales());
		return "sucursales";
	}
	
	@GetMapping("/nuevo")
	public String getNuevaSucursalesPage1(Model model) {
		boolean edicion = false ;
		model.addAttribute("sucursal", sucursal );
		model.addAttribute("edicion",edicion);
		return "nueva_sucursal";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarSucursalPage(@Valid @ModelAttribute("sucursal")FormSucursal sucursal, BindingResult result ) {
		ModelAndView modelView = new ModelAndView("sucursales");
		if(result.hasErrors()) {
			modelView.setViewName("nueva_sucursal");
			modelView.addObject("sucursal", sucursal);
			return modelView;
		}
		listaSucursales.getSucursales().add(sucursal);
		modelView.addObject("sucursales", listaSucursales.getSucursales());
		return modelView;
	}
 
	@GetMapping("/modificar/{nombre}")
	public String getModificarSucursalPage(Model model,@PathVariable(value="nombre")String nombre){
		boolean edicion = true;
		FormSucursal sucursalEncontrada = new FormSucursal();
		for(FormSucursal sucu : listaSucursales.getSucursales()) {
			if(sucu.getNombre().equals(nombre)) {
				sucursalEncontrada = sucu;
				break;
			}
		}
		
		model.addAttribute("sucursal", sucursalEncontrada);
		model.addAttribute("edicion",edicion);
		
		return "nueva_sucursal";	
	}
	@PostMapping("/modificar")
		public String modificarSucursal(@ModelAttribute("sucursal")FormSucursal sucursal) {
			for(FormSucursal sucu: listaSucursales.getSucursales()) { 
				if(sucu.getNombre().equals(sucursal.getNombre())) {
					
					//sucu = sucursal;
					sucu.setDireccion(sucursal.getDireccion());
					sucu.setProvincia(sucursal.getProvincia());
					sucu.setFechaInicio(sucursal.getFechaInicio());
					sucu.setEmail(sucursal.getEmail());
					sucu.setTelefono(sucursal.getTelefono());
					sucu.setEmpleados(sucursal.getEmpleados());
				}
			}
			return "redirect:/sucursales/listado";
	}
	
	@GetMapping("/eliminar/{nombre}")
	public String eliminarSucursal(@PathVariable(value="nombre") String nombre) {
		for(FormSucursal sucu: listaSucursales.getSucursales()) {
			if(sucu.getNombre().equals(nombre)) {
				listaSucursales.getSucursales().remove(sucu);
				break;
				
			}
		}
		
		 return"redirect:/sucursales/listado";
	}
}
	