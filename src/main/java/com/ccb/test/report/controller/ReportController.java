package com.ccb.test.report.controller;

import com.ccb.test.report.service.ReportService;
import com.ccb.test.report.utils.CommonResponse;
import com.ccb.test.report.utils.ResponseUtil;
import com.ccb.test.report.vo.ReportVo;
import com.ccb.test.report.vo.RequestVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {

    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);


    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse report(@RequestBody RequestVo requestVo) {
        logger.info("Start get report from " + requestVo.getEnv());
        List<ReportVo> reports = reportService.getReport(requestVo.getStartDate(), requestVo.getEndDate(), requestVo.getBizCode());
        return ResponseUtil.generateResponse(200,"Success",reports);
    }
}
