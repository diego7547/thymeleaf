package com.example;

import com.example.entity.Alumno;
import com.example.service.AlumnoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(AlumnoService alumnoService){
		return args -> {
			alumnoService.guardarAlumno(new Alumno(null,"diego",19));
			alumnoService.guardarAlumno(new Alumno(null,"liam",12));
			alumnoService.guardarAlumno(new Alumno(null,"luisa",22));

		};
	}
}
