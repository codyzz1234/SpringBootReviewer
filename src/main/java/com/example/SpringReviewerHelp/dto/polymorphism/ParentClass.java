package com.example.SpringReviewerHelp.dto.polymorphism;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class ParentClass {
    protected int age;
    protected String name;

    public void calculateAge(int age) {
        log.info("Calculating Parent Age");
        this.age = age + 5;
        log.info("Parent age is:{}", this.age + 5);
    }
}
