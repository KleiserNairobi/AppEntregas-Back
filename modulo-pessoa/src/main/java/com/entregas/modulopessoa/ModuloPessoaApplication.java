package com.entregas.modulopessoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ModuloPessoaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModuloPessoaApplication.class, args);
	}

}
