package me.step2.demo;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class WebServerApplication {

    @GetMapping("/hello")
    public String hello() {
        return "hello spring";
    }

    public static void main(String[] args) {

        //SpringApplication.run(WebServerApplication.class, args);
        // spring application 의 다양한 기능들을 사용하기 위해 위에 문장을 분리해서 구현한다
        SpringApplication app = new SpringApplication(WebServerApplication.class);
        // ApplicationStartedEvent 는 자동등록이 안되므로 여기에 추가해줘야 한다.
        app.addListeners(new SampleListener());
        app.run(args);
    }

    // ssl 없는 커넥터 생성하는 코드
    @Bean
    public ServletWebServerFactory serverFactory() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addAdditionalTomcatConnectors(craeteStandardConnector());
        return tomcat;
    }

    private Connector craeteStandardConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setPort(8080);
        return connector;
    }
}
