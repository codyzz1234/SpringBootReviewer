package com.example.SpringReviewerHelp.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReport {

    @Schema(name = "reportName", description = "The report name that you want to insert", example = "")
    private String reportName;
}
