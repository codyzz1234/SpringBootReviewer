package com.example.SpringReviewerHelp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// Component scan here analayzes the packages which contains the components.
@SpringBootApplication
@ComponentScan(basePackages = {"com.example.SpringReviewerHelp","com.custompackage"})
public class SpringReviewerHelpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReviewerHelpApplication.class, args);
	}

}
