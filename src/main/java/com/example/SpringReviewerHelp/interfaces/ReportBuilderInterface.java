package com.example.SpringReviewerHelp.interfaces;

import com.example.SpringReviewerHelp.dto.Report;

public interface ReportBuilderInterface {
    default Report createReport(String name) {
        Report report = new Report();
        report.setName(name);
        return report;
    }
}
