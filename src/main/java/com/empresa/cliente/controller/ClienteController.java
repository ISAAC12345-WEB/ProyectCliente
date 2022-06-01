package com.empresa.cliente.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.empresa.cliente.entity.Cliente;
import com.google.gson.Gson;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	public String URL = "http://localhost:8081/api/cliente/";

	@GetMapping("/")
	public String lista(Model model) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Cliente[]> lista = rt.getForEntity(URL + "lista", Cliente[].class);

		model.addAttribute("clientes", lista.getBody());
		model.addAttribute("cliente", new Cliente());
		return "clientes";
	}

	@PostMapping("/registra")
	public String registra(@ModelAttribute Cliente cliente, RedirectAttributes redirect) {
		try {
			Gson gson = new Gson();
			String json = gson.toJson(cliente);
			RestTemplate rt = new RestTemplate();
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> request = new HttpEntity<>(json, headers);

			rt.postForObject(URL + "registra", request, String.class);
			
			redirect.addFlashAttribute("status", "success");
			redirect.addFlashAttribute("mensaje","Cliente registrado");
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("status", "danger");
			redirect.addAttribute("mensaje", "Error al registrar cliente");
		}
		
		return "redirect:/cliente/";
	}
	@DeleteMapping("/elimina/{id}")
		public void elimina(@PathVariable("id") Integer id) {
		
	}
}
