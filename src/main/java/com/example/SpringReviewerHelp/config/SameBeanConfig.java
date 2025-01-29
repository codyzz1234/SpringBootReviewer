package com.example.SpringReviewerHelp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SameBeanConfig {
    @Bean
    public List<String> myString() {
        return List.of("MyString");
    }

    @Bean
    public List<String> yourString() {
        return List.of("YourString");
    }

    @Bean
    public List<String> thatString() {
        return List.of("thatString");
    }
}
