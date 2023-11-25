package com.studentAPI.service;

import com.studentAPI.binding.Department;

import java.util.List;

public interface DepartmentService {

    public void createDepartment(Department department);
    public List<Department> getAllDepartment();
    public void deleteDepartment(Integer id);
    public Department updateDepartment(Department department);
    public Department getDepartmentById(Integer id);
}
