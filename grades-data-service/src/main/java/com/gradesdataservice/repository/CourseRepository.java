package com.gradesdataservice.repository;

import com.gradesdataservice.model.Course;
import com.gradesdataservice.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    Course getCourseByCodeCourse(String courseCode);
    @Query("SELECT c.grades FROM Course c WHERE c.codeCourse = :courseCode")
    List<Grade> findGradesByCourseCode(String courseCode);
}
