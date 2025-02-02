package com.example.SpringReviewerHelp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ProxyingTransactionService {
    @Transactional(propagation = Propagation.MANDATORY)
    public void proxyingTransaction() {
        log.info("Proxying Transaction");
    }
}
