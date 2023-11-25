package com.studentAPI.service;

import com.studentAPI.binding.Teacher;
import com.studentAPI.entities.TeacherEntity;
import com.studentAPI.repository.TeacherRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Id;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepo teacherRepo;

    @Override
    public boolean registerTeacher(Teacher teacher) {
        TeacherEntity teacherEntity = new TeacherEntity();
        BeanUtils.copyProperties(teacher, teacherEntity);
        teacherRepo.save(teacherEntity);
        return true;
    }

    @Override
    public List<Teacher> fetchteacher() {
        List<TeacherEntity> teacherEntity = teacherRepo.findAll();
        List<Teacher> teachers = new ArrayList<>();
        for (TeacherEntity teacher : teacherEntity) {
            Teacher teach = new Teacher();
            BeanUtils.copyProperties(teacher, teach);
            teachers.add(teach);
        }
        return teachers;
    }

    @Override
    public Teacher findteacherById(Integer Id) {
        Optional<TeacherEntity> teacherEntity = teacherRepo.findById(Id);
        if (teacherEntity.isPresent()) {
            TeacherEntity entity = teacherEntity.get();
            Teacher teacher = new Teacher();
            BeanUtils.copyProperties(entity, teacher);
            return teacher;
        }
        return null;
    }

    @Override
    public void deleteTeacherById(Integer Id) {
        Optional<TeacherEntity> teacherEntity = teacherRepo.findById(Id);
        if (teacherEntity.isPresent()) {
            teacherRepo.deleteById(Id);
        } else {
            throw new EntityNotFoundException("Teacher with ID " + Id + " not found");
        }
    }
    @Override
    public Teacher updateTeacher(Teacher teacher) {
        TeacherEntity teacherEntity = teacherRepo.findById(teacher.getId()).get();
        BeanUtils.copyProperties(teacher, teacherEntity);
        teacherRepo.save(teacherEntity);
        // below code is to display to the front end.
        TeacherEntity entity = new TeacherEntity();
        Teacher teac = new Teacher();
        BeanUtils.copyProperties(entity, teac);
        return teacher;
    }

}