package me.step2.demo.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
// WebEnvironment 가 RANDOM_PORT 일 때 테스트 방법 (내장 톰캣 O)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleControllerTest {

    @Autowired
    WebTestClient webTestClient;

    // 테스트시 이 목 빈을 사용한다.
    @MockBean
    SampleService mockSampleService;

    @Test
    public void name() throws Exception {
        when(mockSampleService.getName()).thenReturn("white");

        webTestClient.get().uri("/name").exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("hello white");
    }
}