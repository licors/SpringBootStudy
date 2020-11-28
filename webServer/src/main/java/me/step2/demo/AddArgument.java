package me.step2.demo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class AddArgument {

    public AddArgument(ApplicationArguments arguments) {
        System.out.println("add arguments");
        //vm options
        System.out.println("foo : " + arguments.containsOption("foo"));
        //program arguments
        System.out.println("bar : " + arguments.containsOption("bar"));
    }
}
