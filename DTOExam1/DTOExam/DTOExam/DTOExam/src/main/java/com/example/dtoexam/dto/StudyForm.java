package com.example.dtoexam.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class StudyForm {
    @NotBlank(message="이름을 입력하세요")
    @Size(max=20, message="이름은 20자 이내로 작성하세요")
    private String name;

    @NotNull(message="관심주제를 선택하세요")
    private String topic;

    @NotNull(message="주당 학습시간을 선택하세요")
    @Min(value=1, message="학습 시간은 1시간 이상이어야 합니다")
    @Min(value=40, message="학습 시간은 최대 40시간 이내입니다")
    private Integer studyHours;
    //getter메서드와 setter메서드 (alt + insert)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getStudyHours() {
        return studyHours;
    }

    public void setStudyHours(Integer studyHours) {
        this.studyHours = studyHours;
    }
}
