package com.example.webmvc.user;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/users/create")
    // @ResponseBody 는 @RestController 가 있으므로 생략 가능
    public @ResponseBody User create(@RequestBody User user) {
        //HttpMessageConverters 를 사용해 viewResolver 동작이 아니라 바로 본문으로 변경됨
        return user;
    }
}
