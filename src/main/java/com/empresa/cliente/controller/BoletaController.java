package com.empresa.cliente.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boleta")
public class BoletaController {
	
	@GetMapping("/")
	public String boletaForm() {
		return "Boleta/generaBoleta";
	}
}
