package com.example.week04.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BmiController {
    @GetMapping("/bmi")
    public String calculateBmi(
            @RequestParam(name="name") String name,
            @RequestParam(name="height") double height,
            @RequestParam(name="weight") double weight
    ){
        if (height<=0||weight<=0){
            return "키와 몸무게는 0보다 커야합니다.";

        }
        double heightMeter = height/100.0;
        double bmi = weight/(heightMeter*heightMeter);
        return name + "님의 BMI 는 " + String.format("%.1f",bmi) + " 입니다.";
    }
}
