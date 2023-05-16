package com.gradesdataservice.services.interfaces;

import com.gradesdataservice.DTO.CourseGrade;
import com.gradesdataservice.model.Grade;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ICourseService {
   CourseGrade getGradesByCourseCode(String courseCode);
}
