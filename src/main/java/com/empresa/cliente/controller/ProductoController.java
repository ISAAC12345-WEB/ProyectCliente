package com.empresa.cliente.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.empresa.cliente.entity.Producto;
import com.google.gson.Gson;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	public String URL = "http://localhost:8081/api/producto/";

	@GetMapping("/")
	public String index(Model model) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Producto[]> lista = rt.getForEntity(URL, Producto[].class);

		model.addAttribute("productos", lista.getBody());
		model.addAttribute("producto", new Producto());
		return "productos";
	}

	@PostMapping("/registra")
	public String registra(@ModelAttribute Producto producto, RedirectAttributes redirect) {
		try {
			Gson gson = new Gson();
			String json = gson.toJson(producto);
			RestTemplate rt = new RestTemplate();
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> request = new HttpEntity<>(json, headers);

			rt.postForObject(URL, request, String.class);
			
			redirect.addFlashAttribute("status", "success");
			redirect.addFlashAttribute("mensaje","Producto registrado");
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("status", "danger");
			redirect.addAttribute("mensaje", "Error al registrar producto");
		}
		
		return "redirect:/producto/";
	}
	
}
