package me.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HolomanProperties.class)
public class HolomanConfigure {

    // 빈이 없다면 아래 메소드로 들어와서 프로퍼티를 참조해 값을 세팅하고 빈을 만든다.
    @Bean
    @ConditionalOnMissingBean
    public Holoman holoman(HolomanProperties properties) {
        Holoman holoman = new Holoman();
        holoman.setName(properties.getName());
        holoman.setHowLong(properties.getHowLong());
        return holoman;
    }
}
