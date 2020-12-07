package com.example.springbootrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class RestRunner implements ApplicationRunner {

    @Autowired
    WebClient.Builder builder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        WebClient webClient = builder.build();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Mono<String> helloMono = webClient.get().uri("http://localhost:8080/hello")
                .retrieve()
                .bodyToMono(String.class);
        // subscribe() 를 호출해야 동작이 시작된다.
        // 논블로킹이어서 그냥 지나간다. 응답이 도착해야 아래 코드가 실행됨.
        helloMono.subscribe(s -> {
            System.out.println(s);

            if (stopWatch.isRunning()) {
                stopWatch.stop();
            }
            System.out.println(stopWatch.prettyPrint());
            stopWatch.start();
        });

        // world 가 빨리 끝나므로 먼저 동작완료된다.
        Mono<String> worldMono = webClient.get().uri("http://localhost:8080/world")
                .retrieve()
                .bodyToMono(String.class);
        worldMono.subscribe(s -> {
            System.out.println(s);

            if (stopWatch.isRunning()) {
                stopWatch.stop();
            }
            System.out.println(stopWatch.prettyPrint());
            stopWatch.start();
        });
    }
}
