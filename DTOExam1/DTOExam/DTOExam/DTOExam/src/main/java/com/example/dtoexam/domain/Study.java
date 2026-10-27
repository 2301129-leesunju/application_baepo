package com.example.dtoexam.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//model.addAttribute("studyForm", new StudyForm())
//Study s=new Study(1, 'AAA', "1", 2);
@Entity // Study는 단순한 JAVA 객체가 아니라 JAP가 관리하는 Entity
//JAVA 객체와 db체이블과 매핑되는 객체
public class Study {
    @Id     //이 필드를 Entity의 기본키 즉 P.K로 사용하겠다라는 의미
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //GeneratedValue : 기본키 값을 자동으로 생성하도록 지정
    //IDENTITY : DB에 자동 증가 기능을 이용해서 id를 생성하는 방식
    private Long id; // 스터디 신청번호
    private String name;
    private String topic;
    private Integer studyHours;
    protected Study(){}
    /*
    * JPA가 db 조회 결과를 이용하여 Study 객체를 만들 때 사용하는 기본 생성자
    * JPA Entity에는 매개변수가 없는 public, protected 생성자가 필요
    *
    *
    * */
    public Study(String name, String topic, Integer studyHours) {
        this.name = name;
        this.topic = topic;
        this.studyHours = studyHours;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setStudyHours(Integer studyHours) {
        this.studyHours = studyHours;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTopic() {
        return topic;
    }

    public Integer getStudyHours() {
        return studyHours;
    }
}
/* class : 설계도 (자동차를 만드는 설계도, 썬루프 문짝)
객체 (자동차):썬루프,문짝

class : id, name, topic, studyHours,
생성자 (id, name, topic, studyHours)
getter 메서드

객체를 만들때는 생성자 호출
 */