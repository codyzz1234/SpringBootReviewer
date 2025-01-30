package com.example.SpringReviewerHelp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SameBeanConfig {
    @Bean
    public Integer myInt() {
        return 1;
    }

    @Bean
    public Integer yourInt() {
        return 2;
    }

    @Bean
    public Integer thisInt() {
        return 3;
    }

}
