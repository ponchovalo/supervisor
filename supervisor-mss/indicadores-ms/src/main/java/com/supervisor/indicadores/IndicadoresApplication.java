package com.supervisor.indicadores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class IndicadoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(IndicadoresApplication.class, args);
	}

}
