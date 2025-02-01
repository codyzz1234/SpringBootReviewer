package com.example.SpringReviewerHelp.service;

import com.custompackage.OutsideComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Slf4j
@Service
public class MultipleBeansAutoWireService {

    //Spring will resolve the ambiguity based on the variable name here.
    @Autowired
    private Integer myInt;
    @Autowired
    @Qualifier("yourInt")
    private Integer yourInt;

    @Autowired
    @Qualifier("thisInt")
    private Integer thisInt;

    @Autowired
    private Integer thereInt;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private OutsideComponent outsideComponent;

    public Map<String, Integer> testThis() {
        Integer beanThis = applicationContext.getBean(Integer.class);
        return Map.of(
                "myInt", this.myInt,
                "yourInt", this.yourInt,
                "thisInt", this.thisInt
        );
    }

    public Map<String, String> componentScanOutside() {
        return Map.of(
                "outisideValue", outsideComponent.getOutsideValue(),
                "outsideName", outsideComponent.getOutsideName()
        );
    }
}
