package com.custompackage;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class OutsideComponent {
    private String outsideValue = "outside_value";
    private String outsideName = "outside_name";
}
