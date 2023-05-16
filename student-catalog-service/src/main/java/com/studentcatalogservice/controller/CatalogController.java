package com.studentcatalogservice.controller;

import com.studentcatalogservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CatalogController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/catalog/course/{courseCode}")
    @ResponseStatus(HttpStatus.OK)
    public Catalog getCatalog(@PathVariable String courseCode){

        Course course = restTemplate.getForObject("http://grades-data-service/api/course/"+ courseCode, Course.class);
        CourseGrade courseGrade = restTemplate.getForObject("http://grades-data-service/api/course/"+ courseCode + "/grades", CourseGrade.class);

        Catalog catalog = new Catalog();
        catalog.setCourseCode(course.getCodeCourse());
        List<StudentGrade> studentGrades = new ArrayList<>();

        for (Grade grade : courseGrade.getGrades()){
            Student student = restTemplate.getForObject("http://student-info-service/api/student/"+ grade.getStudentId(), Student.class);
            studentGrades.add(new StudentGrade(student.getName(), student.getAge(), grade.getGrade()));
        }
        catalog.setStudentGrades(studentGrades);
        return catalog;
    }
}
