package com.example.dtoexam.controller;

import com.example.dtoexam.service.StudyService;
import org.springframework.ui.Model;
import com.example.dtoexam.dto.StudyForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.Binding;

@Controller
@RequestMapping("/study") //공통주소인 /study 사용
public class StudyController {
    private final StudyService studyService;
    public StudyController(StudyService studyService){
        this.studyService = studyService;
    }
    @GetMapping("/new")
    public String showStudyForm(Model model){
        model.addAttribute("studyForm", new StudyForm());
        return "study-form";
    }
    @PostMapping
    public String applyStudy(
            @Valid
            @ModelAttribute("studyForm")
        StudyForm studyForm, BindingResult bindingResult
    ){ if(bindingResult.hasErrors()){
        return "study-form";
    }
        studyService.save(studyForm);
        return "redirect:/study";
        //브라우저가 GET 방식으로 /study를 새로 요청
        /*return "study-result";*/
    }
    @GetMapping
    public String showStudyList(Model model){
        model.addAttribute("studies", studyService.findAll());
        return "study-list";
    }
}
/*ModelAttribute 역할
1. 폼에서 전송된 요청 파라미터를 StudyForm 객체의 프로퍼티에 자동으로 바인딩.
2. 만들어진 studyForm 객체를 "studyForm"이라는 이름으로 Model에 추가
따라서 별도로 Model의 메개 변수를 받고 model.addAttribute()를 작성 안해도 됨
 */
/*@valid: StudyForm 객체에 붙어있는 검증조건을 검사하도록 요청하는 역할
BindingResult : 검증결과가 저장되는 곳, hasError()라는 메서드를 통해 오류가
하나라도 있으면 True
 */