package com.alunoonline.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class AlunoOnlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlunoOnlineApplication.class, args);
	}

}
