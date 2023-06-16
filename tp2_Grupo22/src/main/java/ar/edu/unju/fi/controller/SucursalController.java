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
import ar.edu.unju.fi.service.ICommonService;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/sucursales")
public class SucursalController {
    
    @Autowired
    private ListaSucursales listaSucursales;
    
    @Autowired
    private ISucursalService sucursalService;
    
    @Autowired
    private ICommonService commonService;

    /**
     * Maneja la solicitud GET para mostrar la página de lista de sucursales.
     *
     * @param model el modelo para pasar datos a la vista.
     * @return el nombre de la vista "sucursales".
     */
    @GetMapping("/listado")
    public String getListaSucursalesPage(Model model) {
        model.addAttribute("sucursales", listaSucursales.getSucursales());
        return "sucursales";
    }

    /**
     * Maneja la solicitud GET para mostrar la página de creación de una nueva sucursal.
     *
     * @param model el modelo para pasar datos a la vista.
     * @return el nombre de la vista "nueva_sucursal".
     */
    @GetMapping("/nuevo")
    public String getNuevaSucursalPage(Model model) {
        boolean edicion = false;
        model.addAttribute("sucursal", sucursalService.getSucursal());
        model.addAttribute("provincias", commonService.getProvinciaCategoria());
        model.addAttribute("edicion", edicion);
        return "nueva_sucursal";
    }

    /**
     * Maneja la solicitud POST para guardar una nueva sucursal.
     *
     * @param sucursal el objeto FormSucursal a guardar.
     * @param result   el objeto BindingResult que contiene los resultados de la validación.
     * @return un objeto ModelAndView con la vista y los datos del modelo.
     */
    @PostMapping("/guardar")
    public ModelAndView getGuardarSucursalPage(@Valid @ModelAttribute("sucursal") FormSucursal sucursal, BindingResult result) {
        ModelAndView modelView = new ModelAndView("sucursales");
        if (result.hasErrors()) {
            modelView.setViewName("nueva_sucursal");
            modelView.addObject("sucursal", sucursal);
            modelView.addObject("provincias", commonService.getProvinciaCategoria());
            return modelView;
        }
        sucursalService.guardar(sucursal);
        modelView.addObject("sucursales", sucursalService.getLista());
        return modelView;
    }

    /**
     * Maneja la solicitud GET para mostrar la página de modificación de una sucursal existente.
     *
     * @param model  el modelo para pasar datos a la vista.
     * @param nombre el nombre de la sucursal a modificar.
     * @return el nombre de la vista "nueva_sucursal".
     */
    @GetMapping("/modificar/{nombre}")
    public String getModificarSucursalPage(Model model, @PathVariable(value = "nombre") String nombre) {
        FormSucursal sucursalEncontrada = sucursalService.getBy(nombre);
        boolean edicion = true;
        model.addAttribute("sucursal", sucursalEncontrada);
        model.addAttribute("edicion", edicion);
        model.addAttribute("provincias", commonService.getProvinciaCategoria());
        return "nueva_sucursal";
    }

    /**
     * Maneja la solicitud POST para modificar una sucursal existente.
     *
     * @param sucursal el objeto FormSucursal modificado.
     * @param result   el objeto BindingResult que contiene los resultados de la validación.
     * @param model    el modelo para pasar datos a la vista.
     * @return el nombre de la vista "redirect:/sucursales/listado" para redirigir a la lista de sucursales.
     */
    @PostMapping("/modificar")
    public String modificarSucursal(@Valid @ModelAttribute("sucursal") FormSucursal sucursal, BindingResult result, Model model) {
        sucursalService.modificar(sucursal);
        model.addAttribute("provincias", commonService.getProvinciaCategoria());
        return "redirect:/sucursales/listado";
    }

    /**
     * Maneja la solicitud GET para eliminar una sucursal existente.
     *
     * @param nombre el nombre de la sucursal a eliminar.
     * @return el nombre de la vista "redirect:/sucursales/listado" para redirigir a la lista de sucursales.
     */
    @GetMapping("/eliminar/{nombre}")
    public String eliminarSucursal(@PathVariable(value = "nombre") String nombre) {
        FormSucursal sucursalEncontrada = sucursalService.getBy(nombre);
        sucursalService.eliminar(sucursalEncontrada);
        return "redirect:/sucursales/listado";
    }
}