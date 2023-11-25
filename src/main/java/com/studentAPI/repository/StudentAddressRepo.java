package com.studentAPI.repository;

import com.studentAPI.entities.StudentAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentAddressRepo extends JpaRepository<StudentAddressEntity,Integer> {


}
