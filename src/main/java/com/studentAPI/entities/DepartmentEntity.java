package com.studentAPI.entities;

import com.studentAPI.binding.Teacher;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class DepartmentEntity {
    @Id
    private int Depid;
    private String DepName;

    @OneToMany(mappedBy = "departmentEntity")
    private List<StudentEntity> studentEntity;

    @OneToMany(mappedBy = "departmentEntity")
    private List<TeacherEntity> teacherEntities;
}
