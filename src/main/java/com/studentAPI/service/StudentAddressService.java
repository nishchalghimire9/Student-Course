package com.studentAPI.service;

import com.studentAPI.binding.Student;
import com.studentAPI.binding.StudentAddress;

import java.util.List;

public interface StudentAddressService {
    public void CreateStudentAddress(StudentAddress studentAddress);
    public List<StudentAddress> getStudentAddress();

}
