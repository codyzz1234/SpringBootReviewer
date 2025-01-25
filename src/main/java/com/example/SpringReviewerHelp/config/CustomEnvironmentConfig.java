package com.example.SpringReviewerHelp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;

/**
 * This class reads the custom property source file and injects it to the environment interface.
 */
@Configuration
public class CustomEnvironmentConfig {

    private ConfigurableEnvironment environment;

    @Autowired
    public CustomEnvironmentConfig(ConfigurableEnvironment environment) {
        this.environment = environment;
    }
    
    public void addPropertySources() throws IOException {
        PropertySource<?> propertySource = new ResourcePropertySource("classpath:my-values.properties");
        environment.getPropertySources().addLast(propertySource);
    }
}
