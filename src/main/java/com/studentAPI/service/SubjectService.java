package com.studentAPI.service;

import com.studentAPI.binding.Subject;

import java.util.List;

public interface SubjectService {

    public void RegisterClass(Subject subject);
    public List<Subject> fetchSubject();

    public Subject update(Subject subject);
    public void deleteSubject(Integer subjectNum);
    public Subject getSubjectById(Integer subjectNum);
    public void enrolledStudent(Integer studentId ,Integer subjectNum);
}
