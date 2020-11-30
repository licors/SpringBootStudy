package me.step2.demo.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @GetMapping("/name")
    public String name() {
        return "hello " + sampleService.getName();
    }
}
