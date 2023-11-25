package com.studentAPI.service;

import com.studentAPI.binding.Subject;
import com.studentAPI.binding.Teacher;

import java.util.List;

public interface TeacherService {

    public boolean registerTeacher (Teacher teacher);
    public  List<Teacher> fetchteacher();
    public Teacher findteacherById(Integer Id);
    public void deleteTeacherById(Integer Id);
    public Teacher updateTeacher(Teacher teacher);



}
