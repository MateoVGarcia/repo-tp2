package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class productosnavegadorController {
	@GetMapping("/productos")
	public String getProductosPage() {
		return "productos";
	}
}

