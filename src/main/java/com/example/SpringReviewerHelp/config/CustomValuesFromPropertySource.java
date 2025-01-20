package com.example.SpringReviewerHelp.config;

import jdk.jfr.StackTrace;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:my-values.properties")
@ConfigurationProperties(prefix = "property.source")
@Getter
@Setter
public class CustomValuesFromPropertySource {

    private String test;

    private String valueProposition;

    @Bean
    public String returnValueBean() {
        return this.test;
    }

    @Bean
    public String returnValueProposition() {
        return this.valueProposition;
    }

}
