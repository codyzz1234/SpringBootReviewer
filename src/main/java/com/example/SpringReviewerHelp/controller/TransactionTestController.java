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

    @PostMapping(value = "test-transaction-proxy")
    public ResponseEntity<?> testTransactionProxy() {
        return ResponseEntity.status(HttpStatus.OK).body(transactionTestService.transactionOne());
    }

    @PostMapping(value = "bean-test")
    public ResponseEntity<?> beanTest() {
        return ResponseEntity.status(HttpStatus.OK).body(autoWireService.testThis());
    }

    @Operation(summary = "Outisde component api")
    @PostMapping(value = "outiside-component")
    public ResponseEntity<?> outsideComponentTest() {
        return ResponseEntity.status(HttpStatus.OK).body(autoWireService.componentScanOutside());
    }
}
