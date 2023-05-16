package com.gradesdataservice.repository;

import com.gradesdataservice.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository  extends JpaRepository<Grade, Integer> {
    //List<Grade> getAllGrades();
    //List<Grade> getGradesByCodeCourse(String courseCode);
}
