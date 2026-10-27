package com.example.dtoexam.service;

import com.example.dtoexam.domain.Study;
import com.example.dtoexam.dto.StudyForm;
import org.springframework.stereotype.Service;
import java.util.*;

//@Service : 이 클래스가 업무 처리를 담당하는 spring의 객체라는 뜻
//spring이 ProductService 객체를 생성하고 관리
@Service
public class StudyService {
    private final List<Study> studies= new ArrayList<>();
    private Long sequence=1L; //스터디 신청에 부여할 번호
    public void save(StudyForm studyForm){
        Study study=new Study(
                sequence++,
                studyForm.getName(),
                studyForm.getTopic(),
                studyForm.getStudyHours()
                );
        studies.add(study);
    }
    public List<Study> findAll(){
        return studies;
    }
}