package com.gradesdataservice.controller;

import com.gradesdataservice.DTO.CourseGrade;
import com.gradesdataservice.model.Course;

import com.gradesdataservice.model.Grade;
import com.gradesdataservice.repository.CourseRepository;
import com.gradesdataservice.repository.GradeRepository;
import com.gradesdataservice.services.interfaces.ICourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    GradeRepository gradeRepository;
    @Autowired
    ICourseService courseService;

    @GetMapping("/course/{courseCode}")
    @ResponseStatus(HttpStatus.OK)
    public Course getCourseByCourseCode(@PathVariable String courseCode){
        return courseRepository.findById(courseCode).get();
    }

    @GetMapping("course/{courseCode}/grades")
    @ResponseStatus(HttpStatus.OK)
    public CourseGrade getGradesByCourseCode(@PathVariable String courseCode){

        return courseService.getGradesByCourseCode(courseCode);
    }

}
