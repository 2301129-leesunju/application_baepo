package com.example.week04.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloControler {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
//    @GetMapping("")
//    public String hi(){
//        return "서버시작";
//    }
    @GetMapping("/welcome")
    public String welcome(@RequestParam(name="name") String name){
        // name : @RequestParam 어노테이션 이름 , 이름이 name
        // "name" : (브라우저가 보낸 요청 파라미터 이름) , Query String 에서 이름이 name 인 값을 찾는다.
        // String name : 자바의 name 변수 이름
        // 값이 없는 경우 400 ERROR = Bad request
        return name + "님 환영합니다.";
    }
    @GetMapping("/welcomeHi")
    public String welcomeHi(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "category") String category) {

        return name + "님이 " + category + "에 접속하셨습니다.";
    }

}
