package com.studentAPI.service;

import com.studentAPI.binding.Subject;
import com.studentAPI.entities.StudentEntity;
import com.studentAPI.entities.SubjectEntity;
import com.studentAPI.repository.StudentRepo;
import com.studentAPI.repository.SubjectRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepo subjectRepo;
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public void RegisterClass(Subject subject) {
        SubjectEntity crsEntity = new SubjectEntity();
        BeanUtils.copyProperties(subject, crsEntity);
        subjectRepo.save(crsEntity);
        //return "register successfully";
    }

    @Override
    public List<Subject> fetchSubject() {
        List<SubjectEntity> subjectEntity = subjectRepo.findAll();
        List<Subject> subject = new ArrayList<>();
        for (SubjectEntity subjectEn : subjectEntity) {
            Subject subj = new Subject();
            BeanUtils.copyProperties(subjectEn, subj);
            subject.add(subj);
        }
        return subject;
    }

    @Override
    public Subject update(Subject subject) {
        SubjectEntity subjectEntity = subjectRepo.findById(subject.getSubjectNum()).get();
        BeanUtils.copyProperties(subject, subjectEntity);
        subjectRepo.save(subjectEntity);

        Subject subj = new Subject();
        BeanUtils.copyProperties(subjectEntity, subj);
        return subject;
    }

    @Override
    public void deleteSubject(Integer subjectNum) {

        Optional<SubjectEntity> Optional = subjectRepo.findById(subjectNum);
        if (Optional.isPresent()) {
            subjectRepo.deleteById(subjectNum);
        } else {
            //"we need to handle the exception"
        }
    }

    @Override
    public Subject getSubjectById(Integer subjectNum) {

        Optional<SubjectEntity> optional = subjectRepo.findById(subjectNum);
        if (optional.isPresent()) {
            SubjectEntity subjectEntity = optional.get();
            Subject subject = new Subject();
            BeanUtils.copyProperties(subjectEntity, subject);
            return subject;

        } else { // need to handle exception
            return null;
        }
    }


    // this method is implemented for one
    @Override
    public void enrolledStudent(Integer studentId, Integer subjectNum) {
        StudentEntity studentEntity = studentRepo.findById(studentId).get();
        SubjectEntity subjectEntity = subjectRepo.findById(subjectNum).get();

    }
}