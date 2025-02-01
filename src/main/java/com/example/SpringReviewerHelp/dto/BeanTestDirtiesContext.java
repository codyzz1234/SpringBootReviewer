package com.example.SpringReviewerHelp.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Component
@Getter
@Setter
public class BeanTestDirtiesContext {

    Collection< User> userList = new ArrayList<>();
    @Getter
    @Setter
    public static class User {
        private String name;
        private Integer age;
        private LocalDate birthDate;
    }
}
