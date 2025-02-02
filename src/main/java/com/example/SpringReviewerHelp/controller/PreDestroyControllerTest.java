package com.example.SpringReviewerHelp.controller;

import com.example.SpringReviewerHelp.beans.PreDestroyBean;
import io.swagger.v3.oas.annotations.Operation;
import org.hibernate.annotations.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "pre-destroy")
public class PreDestroyControllerTest {
    @Autowired
    private ConfigurableApplicationContext context;



    @Operation(summary = "This method destroys the bean, check logs to see @PreDestroy method")
    @PostMapping(value = "destroy-bean")
    public ResponseEntity<?> preDestroyBeanTest() {
        PreDestroyBean preDestroyBean = (PreDestroyBean) context.getBean("preDestroyBean");
        context.getBeanFactory().destroyBean(preDestroyBean);
        return ResponseEntity.ok().body(Map.of("beanDestroyed", "preDestroyBean"));
    }
}
