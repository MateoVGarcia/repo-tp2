package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SucursalNavegadorController {
	@GetMapping("/sucursales")
	public String getSucursalesPage() {
		return "sucursales";
	}
}

