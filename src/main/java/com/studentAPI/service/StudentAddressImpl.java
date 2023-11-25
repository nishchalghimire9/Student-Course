package com.studentAPI.service;

import com.studentAPI.binding.StudentAddress;
import com.studentAPI.entities.StudentAddressEntity;
import com.studentAPI.repository.StudentAddressRepo;
import com.sun.jdi.request.DuplicateRequestException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class StudentAddressImpl implements StudentAddressService {
@Autowired
private StudentAddressRepo studentAddressRepo;

    @Override
    public void CreateStudentAddress(StudentAddress studentAddress) {
        if (studentAddress != null){
            StudentAddressEntity studentAddr = new StudentAddressEntity();
        BeanUtils.copyProperties(studentAddress, studentAddr);
        studentAddressRepo.save(studentAddr);
    }else{ throw new DuplicateRequestException("record exist");

    }
    }

    @Override
    public List<StudentAddress> getStudentAddress() {

        List<StudentAddressEntity> studentAddressEntities = studentAddressRepo.findAll();
        List<StudentAddress> studentAddresses = new ArrayList<>();
        for (StudentAddressEntity studentAddressEntity: studentAddressEntities){
            StudentAddress address = new StudentAddress();
            BeanUtils.copyProperties(studentAddressEntity, address);
            studentAddresses.add(address);
        }

        return studentAddresses;
    }
}
