package com.entregas.security;

import com.entregas.security.configs.RSAKeyRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RSAKeyRecord.class)
public class ModuloSegurancaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModuloSegurancaApplication.class, args);
	}

}
