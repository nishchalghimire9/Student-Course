package com.studentAPI.entities;

import com.studentAPI.binding.Student;
import com.studentAPI.binding.Subject;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    private String name;
    private String address;
    @Column(unique = true)
    private String phoneNo;
    private LocalDate dob;
    private LocalDate dateEnrolled;
// one to one goes in single not in list.
    @OneToOne  // one student can have one Address, so one to one
    @JoinColumn(name = "std_address_id") // name is given to the join column
    private StudentAddressEntity stAddress;

    @ManyToOne  // it looks for student as many and one for department. that means many students can have one department.
    @JoinColumn(name ="department_id")
    private DepartmentEntity departmentEntity;

    @ManyToMany(mappedBy = "enrolledStudents")  //  enrolledStudents is because the field name in declare that in
    private List<SubjectEntity> subjectEntities;



//    @OneToMany(targetEntity = SubjectEntity.class, cascade = CascadeType.ALL)
//    @JoinColumn(name="Student_id_Fk", referencedColumnName = "studentId")
//    private List<SubjectEntity> courses;
}
