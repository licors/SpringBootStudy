package me.step2.demo;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

//ApplicationStartedEvent 는 applicationContext 가 만들어지기 전에 실행됨
public class SampleListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        System.out.println("================");
        System.out.println("Application is starting");
        System.out.println("================");
    }
}
