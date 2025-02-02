package com.example.SpringReviewerHelp.controller;

import com.example.SpringReviewerHelp.service.ComponentScanTestService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "component-scan")
public class ComponentScanTestController {
    @Autowired
    private ComponentScanTestService componentScanTestService;
    @Operation(summary = "Component Scan test")
    @PostMapping(value = "component-test")
    public ResponseEntity<?> componentScanTest() {
        return ResponseEntity.status(HttpStatus.OK).body(componentScanTestService.outsideComponentTest());

    }
}
