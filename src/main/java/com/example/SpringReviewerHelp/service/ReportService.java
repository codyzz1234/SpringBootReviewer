package com.example.SpringReviewerHelp.service;

import com.example.SpringReviewerHelp.consts.ErrorConstants;
import com.example.SpringReviewerHelp.dto.Report;
import com.example.SpringReviewerHelp.exceptions.CustomCheckedReportException;
import com.example.SpringReviewerHelp.interfaces.ReportBuilderInterface;
import com.example.SpringReviewerHelp.model.CreateReport;
import com.example.SpringReviewerHelp.repository.ReportRepository;
import com.example.SpringReviewerHelp.util.ServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Slf4j
@Service
@ConditionalOnBean
public class ReportService implements ReportBuilderInterface {

    private static final String REPORT_EMPTY_ERROR_MESSAGE_CHECKED = "Report Name is empty(Checked Exception)";
    private static final String REPORT_EMPTY_ERROR_MESSAGE_UNCHECKED = "Report Name is empty(Unchecked Exception)";


    @Autowired
    @Qualifier("returnValueBean")  // Matches the @Bean method name
    private String myReturnValueBean;

    @Autowired
    @Qualifier("returnValueProposition")  // Matches the @Bean method name
    private String returnValueProposition;


    private static final String DEFAULT_CREATOR = "Cody";

    @Autowired
    private ReportRepository reportRepository;

    /**
     * Test checked and unchecked exceptions
     * @param createReport
     * @return
     * @throws CustomCheckedReportException
     */
    @Transactional
    public Report createReport(CreateReport createReport) throws CustomCheckedReportException {
        Report report = ReportBuilderInterface.super.createReport(createReport.getReportName());
        report.setCreatedBy(DEFAULT_CREATOR);
        reportRepository.save(report);
        if (ServiceUtil.checkIfStringIsNullOrEmpty(report.getName())) {
            throw new CustomCheckedReportException(ErrorConstants.VALIDATION_ERROR, REPORT_EMPTY_ERROR_MESSAGE_CHECKED);
        }
//        if (report.getName().trim().length() < 10) {
//            throw new CustomUncheckedReportException(ErrorConstants.VALIDATION_ERROR, REPORT_EMPTY_ERROR_MESSAGE_UNCHECKED);
//        }
        return reportRepository.save(report);
    }

    public Map<String, Object> testPropertyBinding() {
        log.info("The property value is:{}", this.myReturnValueBean);
        return Map.of(
                "testValue", this.myReturnValueBean,
                "myValueProposition", this.returnValueProposition
        );
    }
}
