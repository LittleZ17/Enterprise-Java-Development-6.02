package com.studentinfoservice.controller;

import com.studentinfoservice.model.Student;
import com.studentinfoservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/student/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student getStudentInfo(@PathVariable String id){
        return studentRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
    }
}
