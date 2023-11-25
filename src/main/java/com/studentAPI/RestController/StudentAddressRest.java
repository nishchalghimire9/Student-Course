package com.studentAPI.RestController;

import com.studentAPI.binding.StudentAddress;
import com.studentAPI.entities.StudentAddressEntity;
import com.studentAPI.service.StudentAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentAddressRest {
    @Autowired
    private StudentAddressService addressService;

    @PostMapping("/createStudentAddress")
    public ResponseEntity<String> createStdAddress(@RequestBody StudentAddress studentAddress){
        addressService.CreateStudentAddress(studentAddress);
        return new ResponseEntity<>("student address is created sucessfully", HttpStatus.CREATED);

    }
    @GetMapping("/getAllStudentsAddress")
    public ResponseEntity < List<StudentAddress>> getAllstudentAddress(){
      List<StudentAddress>  address= addressService.getStudentAddress();
        return  new ResponseEntity<>(address, HttpStatus.OK);

    }


}
