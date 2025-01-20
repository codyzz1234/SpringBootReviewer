package com.example.SpringReviewerHelp.exceptionhandler;

import com.example.SpringReviewerHelp.exceptions.CustomCheckedReportException;
import com.example.SpringReviewerHelp.exceptions.CustomUncheckedReportException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {CustomCheckedReportException.class, CustomUncheckedReportException.class})
    public ResponseEntity<?> createReportExceptionResponse(Exception exception) {
        if (exception instanceof CustomCheckedReportException error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getErrorMessage());
        }
        if (exception instanceof CustomUncheckedReportException error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getErrorMessage());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Default REspouse");
    }
}
