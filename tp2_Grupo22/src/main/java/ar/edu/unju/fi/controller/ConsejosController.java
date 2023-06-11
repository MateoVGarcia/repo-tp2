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

import ar.edu.unju.fi.model.Consejo;
import ar.edu.unju.fi.service.ICommonService;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/consejos")
public class ConsejosController {
	@Autowired
	private IConsejoService consejoService;
	
	@Autowired
	private ICommonService commonService;
	
	
	//Pagina con el listado de los consejos (Cada uno está separado por categoría con th:if)
@GetMapping("/listado")
public String getConsejosPage(Model model) {
	model.addAttribute("consejos", consejoService.getConsejos());
	return "consejos";
}


	//Pagina para crear un consejo nuevo
@GetMapping("/nuevo")
public String getNuevoConsejoPage(Model model) {
	boolean edicion = false ;
	model.addAttribute("consejo", consejoService.getConsejo());
	model.addAttribute("categorias", commonService.getConsejoCategoria());
	model.addAttribute("edicion",edicion);
	return "nuevo_consejo";
}

@GetMapping("/modificar/{descripcion}")
public String getModificarConsejosPage(Model model,@PathVariable(value="descripcion")String desc){
	boolean edicion = true;
	Consejo consejoEncontrado = consejoService.getBy(desc);
	model.addAttribute("consejo", consejoEncontrado);
	model.addAttribute("categorias", commonService.getConsejoCategoria());
	model.addAttribute("edicion",edicion);
	
	return "nuevo_consejo";	
}

@PostMapping("/modificar")
public String modificarConsejo(@ModelAttribute("consejo")Consejo consejo) {
	consejoService.modificar(consejo);
	return "redirect:/consejos/listado";
}

	//Pagina de guardado de los consejos
@PostMapping("/guardar")
public ModelAndView getGuardarConsejoPage(@Valid @ModelAttribute("consejo")Consejo consejo, BindingResult result) {
	ModelAndView modelView = new ModelAndView("consejos");
	if(result.hasErrors()) {
		modelView.setViewName("nuevo_consejo");
		modelView.addObject("consejo", consejo);
		modelView.addObject("categorias", commonService.getConsejoCategoria());
		return modelView;
	}
	consejoService.guardar(consejo);
	modelView.addObject("consejos", consejoService.getConsejos());
	return modelView;
}

	//Pagina para eliminar consejos
@GetMapping("/eliminar/{descripcion}")
public String eliminarConsejo(@PathVariable(value="descripcion") String desc) {
			Consejo consejoEncontrado = consejoService.getBy(desc);
			consejoService.eliminar(consejoEncontrado);

	
	 return"redirect:/consejos/listado";
}

}
