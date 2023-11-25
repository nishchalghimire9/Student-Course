package com.studentAPI.service;

import com.studentAPI.binding.Student;
import com.studentAPI.entities.StudentEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface StudentService {
 public boolean studentRegister(Student student);

 public List<Student> fetchStudent();

 public void deleteStudentRecord(Integer studentId);

 public Student findStudentById(Integer studentId);

 public Student updateStudent(Student student);


}
