package com.gradesdataservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    private String codeCourse;
    private String nameCourse;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "courses_grades",
            joinColumns = { @JoinColumn(name = "course_id")},
            inverseJoinColumns = { @JoinColumn(name = "grade_id")}
    )
    private List<Grade> grades;
}
