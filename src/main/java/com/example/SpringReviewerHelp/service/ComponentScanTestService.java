package com.example.SpringReviewerHelp.service;

import com.custompackage.OutsideComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ComponentScanTestService {
    @Autowired
    private OutsideComponent outsideComponent;

    public Map<String, Object> outsideComponentTest() {
        return Map.of(
                "outsideName", this.outsideComponent.getOutsideName(),
                "outsideValue", this.outsideComponent.getOutsideValue()
        );
    }
}
