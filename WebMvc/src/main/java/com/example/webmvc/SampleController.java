package com.example.webmvc;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Controller
public class SampleController {

    @GetMapping("/thymeleafTest")
    public String templateTest(Model model) {
        // ModelAndView 쓸 수도 있지만 리턴값이 뷰 이름이므로 여기서 모델 사용
        model.addAttribute("name","ahm");
        return "thymeleafTest";
    }

    @GetMapping("/ExceptionTest")
    public String hello() {
        throw new SampleException();
    }

    // 전역적으로 하고싶으면 따로 클래스 만들로 @ControllerAdvice 붙여서 아래 ExceptionHandler 구현
    @ExceptionHandler(SampleException.class)
    // AppError 클래스에 정보를 담아 리턴
    public @ResponseBody AppError sampleError(SampleException e) {
        AppError appError = new AppError();
        appError.setMessage("error.app.key");
        appError.setReason("IDK IDK IDK");
        return appError;
    }

    @GetMapping("/hateoasTest")
    public @ResponseBody EntityModel<Hello> hatoeoasTest() {
        Hello hello = new Hello();
        hello.setPrefix("Hey,");
        hello.setName("ahm");

        EntityModel<Hello> helloEntityModel = new EntityModel<>(hello);
        helloEntityModel.add(linkTo(methodOn(SampleController.class).hatoeoasTest()).withSelfRel());
        return helloEntityModel;
    }
}
