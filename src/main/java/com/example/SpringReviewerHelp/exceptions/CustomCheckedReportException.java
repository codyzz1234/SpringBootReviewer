package com.example.SpringReviewerHelp.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomCheckedReportException extends Exception {
    private String errorCode;
    private String errorMessage;

    public CustomCheckedReportException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
