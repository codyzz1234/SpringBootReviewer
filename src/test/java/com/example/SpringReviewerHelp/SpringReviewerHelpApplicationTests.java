package com.example.SpringReviewerHelp;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@Slf4j
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class SpringReviewerHelpApplicationTests {

	@Value("${dev.myvalue.property}")
	private String myValue;
	@Test
	void contextLoads() {
		log.info("My value is :{}", myValue);
	}

}
