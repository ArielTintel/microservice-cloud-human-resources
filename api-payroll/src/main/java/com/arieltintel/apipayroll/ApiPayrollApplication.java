package com.arieltintel.apipayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApiPayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPayrollApplication.class, args);
	}

}
