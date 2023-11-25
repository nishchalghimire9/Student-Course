package com.studentAPI.service;

import com.studentAPI.binding.Student;
import com.studentAPI.entities.StudentEntity;
import com.studentAPI.entities.SubjectEntity;
import com.studentAPI.exception.PhonenumberExistExe;
import com.studentAPI.repository.StudentRepo;
import com.studentAPI.repository.SubjectRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    //THIS LOGIC IS TO POST THE DATA IN TO THE DATABASE.
    @Override
    public boolean studentRegister(Student student) {

        StudentEntity studentEntity = new StudentEntity();
        BeanUtils.copyProperties(student, studentEntity);
        try {
            studentRepo.save(studentEntity);
            return true;
        }catch(Exception ex){
            throw new PhonenumberExistExe();  // here exception has been handled globally
        }

    }

    @Override
    public List<Student> fetchStudent() {
        List<StudentEntity> studentEntity = studentRepo.findAll();
        List<Student> students = new ArrayList<>();
        for (StudentEntity studentEn : studentEntity) {
            Student student = new Student();
            BeanUtils.copyProperties(studentEn, student);
            students.add(student);
        }
        return students;
    }

    @Override
    public void deleteStudentRecord(Integer studentId) {
        Optional<StudentEntity> Optional = studentRepo.findById(studentId);
        if (Optional.isPresent()) {
            studentRepo.deleteById(studentId);
        } else {
            // we need to handle
        }

    }

    @Override
    public Student findStudentById(Integer studentId) {
        Optional<StudentEntity> Optional = studentRepo.findById(studentId);
        if (Optional.isPresent()) {
            StudentEntity studentEntity = Optional.get();
            Student std = new Student();
            BeanUtils.copyProperties(studentEntity, std);
            return std;
        } else {// we need to handle the error
            return null;
        }

    }
@Override
    public Student updateStudent(Student student) {
       StudentEntity studentEntity= studentRepo.findById(student.getStudentId()).get();
        BeanUtils.copyProperties(student, studentEntity);
        studentRepo.save(studentEntity);
        return student;

    }




}