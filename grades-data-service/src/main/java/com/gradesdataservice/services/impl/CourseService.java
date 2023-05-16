package com.gradesdataservice.services.impl;

import com.gradesdataservice.DTO.CourseGrade;
import com.gradesdataservice.model.Course;
import com.gradesdataservice.model.Grade;
import com.gradesdataservice.repository.CourseRepository;
import com.gradesdataservice.repository.GradeRepository;
import com.gradesdataservice.services.interfaces.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class CourseService implements ICourseService {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    GradeRepository gradeRepository;

    @Override
    public CourseGrade getGradesByCourseCode(String courseCode) {
        Course course = courseRepository.getCourseByCodeCourse(courseCode);
        List<Grade> gradeList = courseRepository.findGradesByCourseCode(courseCode);
        CourseGrade courseGrade = new CourseGrade();
        courseGrade.setCourseId(courseCode);
        courseGrade.setGrades(gradeList);
        return courseGrade;
    }

    public void addGradeToCourse(Integer gradeId, String courseId) {
        Course course= courseRepository.findById(courseId).get();
        Grade grade = gradeRepository.findById(gradeId).get();
        course.getGrades().add(grade);
        courseRepository.save(course);
    }
}
