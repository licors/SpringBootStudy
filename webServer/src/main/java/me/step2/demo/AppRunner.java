package me.step2.demo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

// 추상화 레벨에서 실행이 가능해서 좋다.
// CommandLineRunner 도 있다. 이거는 스트링 배열로 인자값 들어온다.
// 모두 JVM 옵션은 못 받고 arguments 만 받을 수 있다.
@Component
public class AppRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        //vm options  -D 로 사용
        System.out.println("foo : " + args.containsOption("foo"));
        //program arguments  -- 로 사용
        System.out.println("bar : " + args.containsOption("bar"));
    }
}
