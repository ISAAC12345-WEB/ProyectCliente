package com.empresa.cliente.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.empresa.cliente.entity.Empleado;
import com.google.gson.Gson;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
	
	public String URL = "http://localhost:8081/api/empleado/";

	@GetMapping("/")
	public String lista(Model model) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Empleado[]> lista = rt.getForEntity(URL + "lista", Empleado[].class);

		model.addAttribute("empleados", lista.getBody());
		model.addAttribute("empleado", new Empleado());
		return "empleados";
	}

	@PostMapping("/registra")
	public String registra(@ModelAttribute Empleado empleado, RedirectAttributes redirect) {
		try {
			Gson gson = new Gson();
			String json = gson.toJson(empleado);
			RestTemplate rt = new RestTemplate();
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> request = new HttpEntity<>(json, headers);

			rt.postForObject(URL + "registra", request, String.class);
			
			redirect.addFlashAttribute("status", "success");
			redirect.addFlashAttribute("mensaje","Producto registrado");
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("status", "danger");
			redirect.addAttribute("mensaje", "Error al registrar producto");
		}
		
		return "redirect:/empleado/";
	}
	
	@PutMapping("/actualiza")
	public String actualiza(@ModelAttribute Empleado empleado, RedirectAttributes redirect) {
		try {
			Gson gson = new Gson();
			String json = gson.toJson(empleado);
			RestTemplate rt = new RestTemplate();
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> request = new HttpEntity<>(json, headers);

			rt.put(URL + "actualiza", request, String.class);
			
			redirect.addFlashAttribute("status", "success");
			redirect.addFlashAttribute("mensaje","Empleado actualizado");
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("status", "danger");
			redirect.addAttribute("mensaje", "Error al actualizar empleado");
		}
		
		return "redirect:/empleado/";
	}

}
