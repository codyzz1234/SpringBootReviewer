package com.example.SpringReviewerHelp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class TransactionTestService {

    @Autowired
    private ProxyingTransactionService proxyingTransactionService;

    @Transactional(propagation = Propagation.REQUIRED)
    public String transactionOne() {
        transactionTwo();
        return "Check Logs for transaction";
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    private String transactionTwo(){
        log.info("Started Transaction two method");
        return "Transaction Two";
    }

    // This should throw an exception, since  proxyingTransction() requires a mandatory existing transaction.
    public String proxyingTransactionOne() {
        log.info("Transaction proxy one");
        proxyingTransactionService.proxyingTransaction();
        return "Proxying transaction";
    }
}
