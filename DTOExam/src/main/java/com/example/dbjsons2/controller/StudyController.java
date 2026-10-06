package com.example.dbjsons2.controller;

import com.example.dbjsons2.dto.StudyForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudyController {
    @GetMapping("/study/new")
    public String showStudyForm(Model model){
        model.addAttribute("studyForm",new StudyForm());
        return "study-form";
    }
    @PostMapping("/study")
    public String applyStudy(
            @Valid
            @ModelAttribute("studyForm")
                             StudyForm studyForm, BindingResult bindingResult

                             ){
        if (bindingResult.hasErrors()){
            return "study-form";
        }
        return "study-result";

    }
}
/*ModelAttribute 역할
*   1. 폼에서 전송된 요청 파라미터를 StudyForm 객체의 프로퍼티에 자동으로 바인딩
*   2. 만들어진 StudyForm 객체를 "studyForm"이라는 이름으로 Model에 저장?
*   따라서 별도로 Model의 매개변수를 받고 model.addAttribute()에 작성하지 않아도 됨.
*
* */
