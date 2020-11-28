package me.step2.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

// 추상화 레벨에서 실행이 가능해서 좋다.
// CommandLineRunner 도 있다. 이거는 스트링 배열로 인자값 들어온다.
// 모두 JVM 옵션은 못 받고 arguments 만 받을 수 있다.
@Component
public class AppRunner implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(AppRunner.class);

    @Autowired
    TestProperties testProperties;

    @Autowired
    private String hello;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        logger.debug("app runner");
        //vm options  -D 로 사용
        System.out.println("foo : " + args.containsOption("foo"));
        //program arguments  -- 로 사용
        System.out.println("bar : " + args.containsOption("bar"));

        logger.debug(testProperties.getName());
        logger.debug("" + testProperties.getAge());
        logger.debug(testProperties.getFullName());
        logger.debug("" + testProperties.getSessionTimeout());

        System.out.println(hello);
    }
}
