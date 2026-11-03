package com.example.product.service;

import com.example.product.domain.Study;
import com.example.product.dto.StudyForm;
import com.example.product.repository.StudyRepository;
import org.springframework.stereotype.Service;
import java.util.*;

//@Service : 이 클래스가 업무 처리를 담당하는 spring의 객체라는 뜻
//spring이 ProductService 객체를 생성하고 관리
@Service
public class StudyService {
    private final StudyRepository studyRepository;
    public StudyService(StudyRepository studyRepository){
        this.studyRepository=studyRepository;
    }
    // 기존에는 등록을 할 때 StudyForm 을 통해 직접 받았지만,
    //MVC, REST API 에서 함께 사용할 수 있도록 실제 업무에 필요한 값들만 전달 받음
    //이때 StudyForm은 그대로 사용을 하지만 객체 전체를 Controller에 넘기지 않고
    //Controller 에서 필요한 값들만 꺼내 Service에 전달
    public Study save(String name, String topic, Integer studyHours){
        Study study=new Study(
                name,
                topic,
                studyHours
                );
        return studyRepository.save(study);
        //Repository를 통해 h2 db에 저장
    }
    public List<Study> findAll(){
        return studyRepository.findAll();
    }
}