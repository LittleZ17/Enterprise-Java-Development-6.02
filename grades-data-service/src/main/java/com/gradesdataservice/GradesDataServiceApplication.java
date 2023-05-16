package com.gradesdataservice;

import com.gradesdataservice.model.Course;
import com.gradesdataservice.model.Grade;
import com.gradesdataservice.repository.CourseRepository;
import com.gradesdataservice.repository.GradeRepository;
import com.gradesdataservice.services.impl.CourseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class GradesDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradesDataServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner run (CourseRepository courseRepository, GradeRepository gradeRepository, CourseService courseService){
		return args -> {
			courseRepository.save(new Course("C01", "Data-Analytic", new ArrayList<>()));
			gradeRepository.save(new Grade(null, 2, "st1"));
			gradeRepository.save(new Grade(null, 5, "st2"));

			courseService.addGradeToCourse(1, "C01");
			courseService.addGradeToCourse(2, "C01");

		};
	}
}
