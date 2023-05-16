package com.gradesdataservice.controller;

import com.gradesdataservice.model.Grade;
import com.gradesdataservice.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GradeController {
    @Autowired
    GradeRepository gradeRepository;

    @GetMapping("/grades")
    @ResponseStatus(HttpStatus.OK)
    public List<Grade> getAllGrades(){
        return gradeRepository.findAll();
    }
}
