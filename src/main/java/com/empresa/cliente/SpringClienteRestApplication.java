package com.empresa.cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.empresa.cliente.controller")
public class SpringClienteRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringClienteRestApplication.class, args);
	}

}
