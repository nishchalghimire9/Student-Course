package com.studentAPI.service;

import com.studentAPI.binding.Department;
import com.studentAPI.entities.DepartmentEntity;
import com.studentAPI.exception.DepartmentNotFoundException;
import com.studentAPI.exception.ExceptionErrorDetails;
import com.studentAPI.repository.DepartmentRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentImpl implements DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public void createDepartment(Department department) {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setDepid(department.getId());

        departmentEntity.setDepName(department.getDepartmentName());
        departmentRepo.save(departmentEntity);

    }

    @Override
    public List<Department> getAllDepartment() {

        List<DepartmentEntity> departmentEntity = departmentRepo.findAll();
        List<Department> departmentList = new ArrayList<>();

        for (DepartmentEntity departmentEnty : departmentEntity) {
            Department departments = new Department();
            departments.setId(departmentEnty.getDepid());
            departments.setDepartmentName(departmentEnty.getDepName());
            departmentList.add(departments);
        }
        return departmentList;
    }

       @Override
    public void deleteDepartment(Integer id) {
        Optional<DepartmentEntity> departmentEntity = departmentRepo.findById(id);
        if (departmentEntity.isPresent()) {
            departmentRepo.deleteById(id);
        } else {
            throw new EntityNotFoundException("department id " + id + " does not exist");
        }
    }

    @Override
    public Department updateDepartment(Department department) {
        DepartmentEntity departmentEntity = departmentRepo.findById(department.getId()).get();
        departmentEntity.setDepid(department.getId());
        departmentEntity.setDepName(department.getDepartmentName());
        departmentRepo.save(departmentEntity);
        // below line is not necessary
//       DepartmentEntity deptEnt=  departmentRepo.save(departmentEntity);
//        Department depart = new Department();
//        depart.setId(deptEnt.getDepid());
//        depart.setDepartmentName(deptEnt.getDepName());
        return department;
    }

    @Override
    public Department getDepartmentById(Integer id) {

            Optional<DepartmentEntity> Optional = departmentRepo.findById(id);
            if (Optional.isPresent()) {
                DepartmentEntity departmentEntity = Optional.get();
                Department department = new Department();
                department.setId(departmentEntity.getDepid());
                department.setDepartmentName(departmentEntity.getDepName());
                return department;
            }
        else  throw new DepartmentNotFoundException();




    }
}
