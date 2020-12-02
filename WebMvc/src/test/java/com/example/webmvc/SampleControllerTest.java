package com.example.webmvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void thymeleafTest() throws Exception {
        mockMvc.perform(get("/thymeleafTest"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(view().name("thymeleafTest"))
                .andExpect(model().attribute("name", is("ahm")))
                .andExpect(content().string(containsString("ahm")));
    }

    // HtmlUnit test 사용법
    //  http://htmlunit.sourceforge.net/
    @Autowired
    WebClient webClient;

    @Test
    public void htmlUnitTest() throws Exception {
        HtmlPage page = webClient.getPage("/thymeleafTest");
        HtmlHeading1 h1 = page.getFirstByXPath("//h1");
        assertThat(h1.getTextContent()).isEqualToIgnoringCase("ahm");
    }

    // properties 에서 spring.jackson... 으로 objectMapper 설정 가능
    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void hateoasTest() throws Exception {
        mockMvc.perform(get("/hateoasTest"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._links.self").exists());
    }
}
