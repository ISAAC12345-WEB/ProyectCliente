package com.empresa.cliente.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@SuppressWarnings("deprecation")
	@GetMapping(value = {"/Dashboard","/"})
	public String Dashboard(Model model) {
		model.addAttribute("now", new Date().getYear() + 1900);
		return "dashboard";
	}
}
