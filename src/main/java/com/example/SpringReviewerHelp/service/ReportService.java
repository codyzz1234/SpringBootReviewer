package com.example.SpringReviewerHelp.service;

import com.example.SpringReviewerHelp.consts.EnvironmentConstants;
import com.example.SpringReviewerHelp.consts.ErrorConstants;
import com.example.SpringReviewerHelp.dto.Report;
import com.example.SpringReviewerHelp.dto.polymorphism.ChildClass;
import com.example.SpringReviewerHelp.dto.polymorphism.ParentClass;
import com.example.SpringReviewerHelp.exceptions.CustomCheckedReportException;
import com.example.SpringReviewerHelp.interfaces.ReportBuilderInterface;
import com.example.SpringReviewerHelp.model.CreateReport;
import com.example.SpringReviewerHelp.repository.ReportRepository;
import com.example.SpringReviewerHelp.util.ServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Slf4j
@Service
public class ReportService implements ReportBuilderInterface {

    private static final String REPORT_EMPTY_ERROR_MESSAGE_CHECKED = "Report Name is empty(Checked Exception)";

    @Autowired
    @Qualifier("returnValueBean")  // Matches the @Bean method name
    private String myReturnValueBean;

    @Autowired
    @Qualifier("returnValueProposition")  // Matches the @Bean method name
    private String returnValueProposition;

    @Autowired
    private Environment environment;


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
        reportRepository.save(report);
        if (ServiceUtil.checkIfStringIsNullOrEmpty(report.getName())) {
            throw new CustomCheckedReportException(ErrorConstants.VALIDATION_ERROR, REPORT_EMPTY_ERROR_MESSAGE_CHECKED);
        }
//        if (report.getName().trim().length() < 10) {
//            throw new CustomUncheckedReportException(ErrorConstants.VALIDATION_ERROR, REPORT_EMPTY_ERROR_MESSAGE_UNCHECKED);
//        }
        return reportRepository.save(report);
    }

    /**
     * Test if application properties properly binding to the variables.
     * @return
     */
    public Map<String, Object> testPropertyBinding() {
        log.info("The property value is:{}", this.myReturnValueBean);
        return Map.of(
                "testValue", this.myReturnValueBean,
                "myValueProposition", this.returnValueProposition
        );
    }

    /**
     * Test if my custom configuration was registered to the environment
     */
    public Map<String, Object> testEnvironmentBinding() {
        String kenleyProperty = environment.getProperty(EnvironmentConstants.KENLEY_PROPERTY);
        String kenleyValueProposition = environment.getProperty(EnvironmentConstants.KENLEY_VALUE_PROPOSITION);
        return Map.of(
                "kenleyProperty", kenleyProperty,
                "kenleyValueProposition", kenleyValueProposition
        );
    }

    /**
     * Child class here overrides the methods calculateAge method. and is resolved at runtime which method ot use
     * @param age - the age parameter passed as a request param
     * @return - returns Map<String,Object> response.
     */
    public Map<String,Object> dynamicPolymorphism(int age) {
        ParentClass parentClass = new ParentClass();
        parentClass.calculateAge(age);

        ParentClass childClass = new ChildClass();
        childClass.calculateAge(age);
        return Map.of("childAge is ", childClass.getAge(),
                        "parentAge is ", parentClass.getAge());
    }

}
