package com.studentAPI.RestController;

import com.studentAPI.binding.Subject;
import com.studentAPI.binding.Teacher;
import com.studentAPI.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TeacherRest {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/registerteacher")
    public ResponseEntity<String> registerTeacher(@RequestBody Teacher teacher) {
        boolean status = teacherService.registerTeacher(teacher);
        if (status) {
            return new ResponseEntity<>("registered successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("problem occured", HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @GetMapping("/getTeachers")
    public ResponseEntity<List<Teacher>> fetchteacher() {
        List<Teacher> teachers = teacherService.fetchteacher();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @GetMapping("/getTeacherById/{Id}")
    public ResponseEntity<Teacher> findTeacherById(@PathVariable("Id") Integer Id) {
        Teacher teacher = teacherService.findteacherById(Id);
        if (teacher != null) {
            return new ResponseEntity<>(teacher, HttpStatus.OK);
        } else {
            return null;
        }
    }
    // this part has logic to handle the error and  getting message
    @DeleteMapping("/deleteTeachers/{Id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable("Id") Integer Id) {
        try {
            teacherService.deleteTeacherById(Id);
            return new ResponseEntity<>("Teacher is deleted successfully", HttpStatus.OK);
        } catch (Exception E) {
            return new ResponseEntity<>("Failed to delete the teacher: " + E.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/updateTeacher/{Id}")
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher){
                teacherService.updateTeacher(teacher);
                return new ResponseEntity<>(teacher,HttpStatus.OK);
    }
}