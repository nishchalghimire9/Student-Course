package com.studentAPI.entities;

import com.studentAPI.binding.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer subjectNum;

    private String subjectName;
    private Integer credits;

    @ManyToMany
    @JoinTable(
            name = "Student_enrolled",
            joinColumns = @JoinColumn(name ="subjectNum"),
            inverseJoinColumns = @JoinColumn(name="studentId")
    )
    private List<StudentEntity>  enrolledStudents;



}
