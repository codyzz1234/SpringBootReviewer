package com.example.SpringReviewerHelp;

import com.example.SpringReviewerHelp.dto.reflection.Child;
import com.example.SpringReviewerHelp.dto.reflection.Parent;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;
import java.time.LocalDate;

@Slf4j
@ExtendWith(MockitoExtension.class)
class ReflectionTest {
    @Test
    void reflectionTest() throws NoSuchFieldException, IllegalAccessException {
        Child child = new Child();
        child.setAge(12);
        child.setBirthDay(LocalDate.now());
        child.setChildSpecificField("ChildSpecificField");
        Field field = Parent.class.getDeclaredField("parentPrivateField");
        field.setAccessible(true);
        field.set(child, "I set the parent field here");
        log.info("Child Value is :{}", child.toString());
    }
}
