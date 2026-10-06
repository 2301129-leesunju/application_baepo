package com.example.dbjsons2.domain;
//model.addAttribute("studyForm", new StudyForm());     <----- 기본 생성자
//StudyForm studyFrom = new StudyForm();                <----- 생성자
public class Study {
    private Long id; //스터디 신청 번호
    private String name;
    private String topic;
    private Integer studyHours;

    public Study(Long id , String name , String topic , Integer studyHours){
        this.id=id;
        this.name=name;
        this.topic=topic;
        this.studyHours=studyHours;
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
