package com.example.SpringReviewerHelp;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


/**
 * Note the profile naming convention here. it is application-test-dev. anything past
 * "application-" here is treated as the profile name.
 */
@Slf4j
@SpringBootTest
@ActiveProfiles("test-dev")
public class ApplicationDevProfileActive {

    @Value("${dev.myvalue.property}")
    private String myValue;
    @Test
    void contextLoads() {
        log.info("My value is :{}", myValue);
    }
}
