package com.example.SpringReviewerHelp.dto.reflection;

import java.time.LocalDate;

public class Parent {
    private int age;
    private String name;
    private LocalDate birthDay;
    private String parentPrivateField;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }
}
