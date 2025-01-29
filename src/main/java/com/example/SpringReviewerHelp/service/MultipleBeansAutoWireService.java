package com.example.SpringReviewerHelp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Slf4j
@Service
public class MultipleBeansAutoWireService {
    @Autowired
    @Qualifier("myString")
    private List<String> thisString;

    public Collection<String> testThis() {
        log.info("This string is:{}", this.thisString);
        return this.thisString;
    }
}
