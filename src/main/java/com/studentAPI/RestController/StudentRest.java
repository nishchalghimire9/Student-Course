package com.studentAPI.RestController;

import com.studentAPI.binding.Student;
import com.studentAPI.service.StudentService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentRest {
    @Autowired
    private StudentService studentService;

    @PostMapping("/studentRegister")
    public ResponseEntity<String> RegisterForClass(@RequestBody Student student) {
    studentService.studentRegister(student);
    return new ResponseEntity<>("Student is register successfully", HttpStatus.CREATED);

        //return new ResponseEntity<>("Student is register successfully", HttpStatus.CREATED);
    }

    @GetMapping("/getStudents")
    public ResponseEntity<List<Student>> fetchStudent() {
        List<Student> studentList = studentService.fetchStudent();
        return new ResponseEntity<>(studentList, HttpStatus.OK);


    }

    @DeleteMapping("/deleteStudentInfo/{studentId}")
    public ResponseEntity<String> deleteStudentRec(@PathVariable("studentId") Integer studentId) {
        studentService.deleteStudentRecord(studentId);
        return new ResponseEntity<>("Student is deleted sucessfully", HttpStatus.OK);
    }

    @GetMapping("/getStudentById/{studentId}")
    public ResponseEntity<?> getStudentById(@PathVariable("studentId") Integer studentId){
       Student st= studentService.findStudentById(studentId);
        if(st != null) {
            return new ResponseEntity<>(st, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Record is not found",HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/updateStudent/{studentId}")
    public ResponseEntity<String> updateStudent(@RequestBody Student student){
        Student sts= studentService.updateStudent(student);
        if(sts != null)
         return new ResponseEntity<>("Student record is updated successfully", HttpStatus.OK);
        else{ // this needs to  be handled.
            return new ResponseEntity<>("student is not update successfully", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    }




