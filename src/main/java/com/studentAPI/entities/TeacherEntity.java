package com.studentAPI.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeacherEntity {
    @Id
    private int Id;
    private String name;

    @ManyToOne  // it mean many teacher can have one department
    @JoinColumn(name =" department_id")
    private DepartmentEntity departmentEntity;
}
