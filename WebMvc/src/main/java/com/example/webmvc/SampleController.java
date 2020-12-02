package com.example.webmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

    @GetMapping("/thymeleafTest")
    public String hello(Model model) {
        // ModelAndView 쓸 수도 있지만 리턴값이 뷰 이름이므로 여기서 모델 사용
        model.addAttribute("name","ahm");
        return "thymeleafTest";
    }
}
