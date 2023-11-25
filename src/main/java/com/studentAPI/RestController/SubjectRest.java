package com.studentAPI.RestController;

import com.studentAPI.binding.Subject;
import com.studentAPI.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectRest {
    @Autowired
    private SubjectService subjectService;

    @PostMapping("/registerSubject")
    public ResponseEntity<String> RegisterClass(@RequestBody Subject subject) {
        //String crs =
        subjectService.RegisterClass(subject);
        return new ResponseEntity<>("Subject is register successfully", HttpStatus.CREATED);

    }

    @GetMapping("/getsubject")
    public ResponseEntity<List<Subject>> fetchSubject() {
        List<Subject> subjec = subjectService.fetchSubject();
        return new ResponseEntity<>(subjec, HttpStatus.OK);
    }

    @PutMapping("/updateSubject/{subjectNum}")
    public ResponseEntity<Subject> updateSubject(@RequestBody Subject subject) {
        Subject subj = subjectService.update(subject);
        return new ResponseEntity<>(subj, HttpStatus.OK);

    }

    @DeleteMapping("/deleteSubject/{subjectNum}")
    public ResponseEntity<String> deleteSubject(@PathVariable ("subjectNum") Integer subjectNum){
       subjectService.deleteSubject(subjectNum);
      return new ResponseEntity<>("Subject is deleted", HttpStatus.OK);
    }

    @GetMapping("/getsubjectById/{subjectNum}")
    public ResponseEntity<Subject> getsubjectByNum(@PathVariable("subjectNum") Integer subjectNum){
       Subject subject =  subjectService.getSubjectById(subjectNum);
        return new ResponseEntity<>(subject,HttpStatus.OK);
    }

    public ResponseEntity getenrolledStudentsToSubject(@PathVariable int studentId, @PathVariable int subjectName){

        subjectService.enrolledStudent(studentId,subjectName);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
