package com.studentAPI.repository;

import com.studentAPI.entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo extends JpaRepository <SubjectEntity, Integer> {
}
