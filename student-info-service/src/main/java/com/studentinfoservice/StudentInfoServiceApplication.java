package com.studentinfoservice;

import com.studentinfoservice.model.Student;
import com.studentinfoservice.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentInfoServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(StudentRepository studentRepository){
		return args -> {
			studentRepository.save(new Student("st1", "Sara Marin", 19));
			studentRepository.save(new Student("st2","Pablo Vera", 18 ));
			studentRepository.save(new Student("st3", "Fernando Herrera", 20));
		};
	}

}
