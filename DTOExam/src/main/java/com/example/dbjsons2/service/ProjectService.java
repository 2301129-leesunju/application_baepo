package com.example.dbjsons2.service;

import com.example.dbjsons2.domain.Study;
import com.example.dbjsons2.dto.StudyForm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {
    List<Study> studies= new ArrayList<>();
    Long sequence = 1L; // 스터디 신청에 부여할 번호
    public void save(StudyForm studyForm){
        Study study = new Study(
                sequence++,
                studyForm.getName(),
                studyForm.getTopic(),
                studyForm.getStudyHours()
                );
        studies.add(study);
        }

}
