package com.example.SpringReviewerHelp;


import com.example.SpringReviewerHelp.dto.BeanTestDirtiesContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;

@Slf4j
@SpringBootTest
@DirtiesContext
/**
 * Without dirties context after method here, the spring bean here maintain it's state.
 *
 */
class DirtiesContextTest {
    @Autowired
    private BeanTestDirtiesContext beanTestDirtiesContext;

    /**
     *   Without dirties context after method here, the spring bean here maintain it's state.
     */
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void addNewUser() {
        log.info("User size is:{}", beanTestDirtiesContext.getUserList().size());
        BeanTestDirtiesContext.User user = new BeanTestDirtiesContext.User();
        user.setAge(15);
        user.setName("Cody");
        user.setBirthDate(LocalDate.now());
        beanTestDirtiesContext.getUserList().add(user);
        Assertions.assertEquals(1, beanTestDirtiesContext.getUserList().size());
    }

    /**
     * Without dirties context after method here, the spring bean here maintain it's state.
     */
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void addAnotherUser() {
        log.info("User size is:{}", beanTestDirtiesContext.getUserList().size());
        BeanTestDirtiesContext.User user = new BeanTestDirtiesContext.User();
        user.setAge(15);
        user.setName("Cody");
        user.setBirthDate(LocalDate.now());
        beanTestDirtiesContext.getUserList().add(user);
        Assertions.assertEquals(1, beanTestDirtiesContext.getUserList().size());
    }
}
