package com.example.SpringReviewerHelp.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomUncheckedReportException extends RuntimeException {
    private String errorCode;
    private String errorMessage;

    public CustomUncheckedReportException( String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
