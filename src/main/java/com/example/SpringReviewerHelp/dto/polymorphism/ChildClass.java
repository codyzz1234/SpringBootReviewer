package com.example.SpringReviewerHelp.dto.polymorphism;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChildClass extends ParentClass {
    @Override
    public void calculateAge(int age) {
        log.info("calculating child age");
        super.age = age - 5;
        log.info("Child Age is: {}", age);
    }
}
