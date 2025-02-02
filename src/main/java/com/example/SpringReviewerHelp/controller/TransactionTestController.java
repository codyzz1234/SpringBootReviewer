package com.example.SpringReviewerHelp.controller;


import com.example.SpringReviewerHelp.service.MultipleBeansAutoWireService;
import com.example.SpringReviewerHelp.service.TransactionTestService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionTestController {
    @Autowired
    private TransactionTestService transactionTestService;

    @Autowired
    private MultipleBeansAutoWireService autoWireService;

    @Operation(summary = "Test Transaction that is non proxying.")
    @PostMapping(value = "test-nonproxy-proxy")
    public ResponseEntity<?> testNonProxyTransaction() {
        return ResponseEntity.status(HttpStatus.OK).body(transactionTestService.transactionOne());
    }

    @Operation(summary = "Should throw exception transaction")
    @PostMapping(value = "test-proxy-transaction")
    public ResponseEntity<?> testProxyTransaction() {
        return ResponseEntity.status(HttpStatus.OK).body(transactionTestService.proxyingTransactionOne());
    }


    @PostMapping(value = "bean-test")
    public ResponseEntity<?> beanTest() {
        return ResponseEntity.status(HttpStatus.OK).body(autoWireService.testThis());
    }
}
