package com.example.SpringReviewerHelp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class TransactionTestService {

    @Transactional(propagation = Propagation.REQUIRED)
    public String transactionOne() {
        transactionTwo();
        return "Check Logs for transaction";
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String transactionTwo(){
        log.info("Started Transaction two method");
        return "Transaction Two";
    }
}
