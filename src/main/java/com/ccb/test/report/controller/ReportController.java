package com.ccb.test.report.controller;

import com.ccb.test.report.service.ReportService;
import com.ccb.test.report.vo.ReportVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {

    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);


    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity report(String env, String startDate, String endDate, String bizCode) {
        logger.info("Start get report from " + env);
        List<ReportVo> reports = reportService.getReport(startDate, endDate, bizCode);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }
}
