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
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/sucursales")
public class SucursalController {
    
    @Autowired
    private ListaSucursales listaSucursales;
    
    @Autowired
    private ISucursalService sucursalService;
    
    /**
     * Muestra la página de listado de sucursales.
     * 
     * @param model el modelo de la vista.
     * @return el nombre de la vista "sucursales".
     */
    @GetMapping("/listado")
    public String getListaSucursalesPage(Model model) {
        model.addAttribute("sucursales", listaSucursales.getSucursales());
        return "sucursales";
    }
    
    /**
     * Muestra la página para crear una nueva sucursal.
     * 
     * @param model el modelo de la vista.
     * @return el nombre de la vista "nueva_sucursal".
     */
    @GetMapping("/nuevo")
    public String getNuevaSucursalPage(Model model) {
        boolean edicion = false;
        model.addAttribute("sucursal", sucursalService.getSucursal());
        model.addAttribute("edicion", edicion);
        return "nueva_sucursal";
    }
    
    /**
     * Guarda una nueva sucursal o actualiza una existente.
     * 
     * @param sucursal el objeto FormSucursal que contiene los datos de la sucursal.
     * @param result el objeto BindingResult para validar los errores.
     * @return un objeto ModelAndView que redirige a la vista "sucursales" o muestra la vista "nueva_sucursal" en caso de errores de validación.
     */
    @PostMapping("/guardar")
    public ModelAndView getGuardarSucursalPage(@Valid @ModelAttribute("sucursal") FormSucursal sucursal, BindingResult result) {
        ModelAndView modelView = new ModelAndView("sucursales");
        if (result.hasErrors()) {
            modelView.setViewName("nueva_sucursal");
            modelView.addObject("sucursal", sucursal);
            return modelView;
        }
        sucursalService.guardar(sucursal);
        modelView.addObject("sucursales", sucursalService.getLista());
        return modelView;
    }
    
    /**
     * Muestra la página para modificar una sucursal existente.
     * 
     * @param model el modelo de la vista.
     * @param nombre el nombre de la sucursal a modificar.
     * @return el nombre de la vista "nueva_sucursal".
     */
    @GetMapping("/modificar/{nombre}")
    public String getModificarSucursalPage(Model model, @PathVariable(value = "nombre") String nombre) {
        FormSucursal sucursalEncontrada = sucursalService.getBy(nombre);
        boolean edicion = true;
        model.addAttribute("sucursal", sucursalEncontrada);
        model.addAttribute("edicion", edicion);
        return "nueva_sucursal";
    }
    
    /**
     * Modifica una sucursal existente.
     * 
     * @param sucursal el objeto FormSucursal que contiene los datos modificados de la sucursal.
     * @return el nombre de la vista "redirect:/sucursales/listado".
     */
    @PostMapping("/modificar")
    public String modificarSucursal(@ModelAttribute("sucursal") FormSucursal sucursal) {
        sucursalService.modificar(sucursal);
        return "redirect:/sucursales/listado";
    }
    
    /**
     * Elimina una sucursal existente.
     * 
     * @param nombre el nombre de la sucursal a eliminar.
     * @return el nombre de la vista "redirect:/sucursales/listado".
     */
    @GetMapping("/eliminar/{nombre}")
    public String eliminarSucursal(@PathVariable(value = "nombre") String nombre) {
        FormSucursal sucursalEncontrada = sucursalService.getBy(nombre);
        sucursalService.eliminar(sucursalEncontrada);
        return "redirect:/sucursales/listado";
    }
}
