package com.studentAPI.RestController;

import com.studentAPI.binding.Department;
import com.studentAPI.service.DepartmentImpl;
import com.studentAPI.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/dep")
public class DepartmentRest {
    // logger are used to generate log message
    private Logger logger = LoggerFactory.getLogger(DepartmentRest.class);
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/createDepartment")
    public ResponseEntity<String> createDepartment(@RequestBody Department department) {
        logger.debug("Department creation process started");// debug will print low level message
        try {
            departmentService.createDepartment(department);
            logger.info("account creation process is completed");
            return new ResponseEntity<>("Department created successfully", HttpStatus.CREATED);
        }catch (Exception e)
        { return new ResponseEntity<>(HttpStatus.CONFLICT); // i have not handle the error here i have not create exception class.
        }
    }

    @GetMapping("/getDepartments")
    public ResponseEntity <List<Department>> getAllDepartments() {
        logger.debug("fetching departments process started");  // debug will print low level message while info will  print high level message.
        List<Department> dep = departmentService.getAllDepartment();
        if (dep != null) {
            logger.info("fetching departments sucessfully");  // debug will print low level message while info will  print high level message.
            return new ResponseEntity<>(dep, HttpStatus.OK);
        }else {
            logger.info("departments are not fetched  sucessfully");
            return new ResponseEntity<>(dep ,HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/deleteDepartment/{id}")
    public ResponseEntity deleteDepartment(@PathVariable ("id") int id) {
        try {
            departmentService.deleteDepartment(id);
            return new ResponseEntity<>("department is deleted successfully", HttpStatus.OK);
        }catch (Exception e){
           return new ResponseEntity<>("department is not deleted successfully: " +e.getMessage (), HttpStatus.OK);
        }
    }
    @PutMapping("/updateDepartment/{id}")
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department){
        Department dep=departmentService.updateDepartment(department);
        return new ResponseEntity<>(dep,HttpStatus.OK);

    }
    @GetMapping(value ="/getDepById/{id}")
    private ResponseEntity<Department> getDepartmentById(@PathVariable("id") int id){
       Department department = departmentService.getDepartmentById(id);
       if(department != null){
          return new ResponseEntity<>(department,HttpStatus.OK);
       }else {
          return new ResponseEntity<>(department,HttpStatus.NOT_FOUND);
       }

    }
}
