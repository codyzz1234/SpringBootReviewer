package com.example.SpringReviewerHelp.controller;

import com.example.SpringReviewerHelp.exceptions.CustomCheckedReportException;
import com.example.SpringReviewerHelp.model.CreateReport;
import com.example.SpringReviewerHelp.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequestMapping(value = "/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @PostMapping
    public ResponseEntity<?> createReport(@RequestBody CreateReport createReport) throws CustomCheckedReportException {
        return ResponseEntity.status(HttpStatus.OK).body(reportService.createReport(createReport));
    }

    @PostMapping(value = "property-test")
    public ResponseEntity<?> testPropertyBinding() {
        return ResponseEntity.status(HttpStatus.OK).body(reportService.testPropertyBinding());
    }

    @PostMapping(value = "custom-envronment-test")
    public ResponseEntity<?> testCustomEnvironment() {
        return ResponseEntity.status(HttpStatus.OK).body(reportService.testEnvironmentBinding());
    }
}
