package com.entregas.moduloendereco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ModuloEnderecoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModuloEnderecoApplication.class, args);
	}

}
