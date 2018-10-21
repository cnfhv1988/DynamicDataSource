package com.ccb.test.report.controller;

import com.ccb.test.report.service.ReportService;
import com.ccb.test.report.utils.CommonResponse;
import com.ccb.test.report.utils.ResponseUtil;
import com.ccb.test.report.vo.ReportBizCodeVo;
import com.ccb.test.report.vo.RequestBizCodeVo;
import com.ccb.test.report.vo.RequestVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/report")
public class ReportController {

    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);


    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse report(@RequestBody RequestVo requestVo) {
        logger.info("Start get report from " + requestVo.getEnv());
        List<RequestBizCodeVo> requestBizCodeVos = requestVo.getTransCodes();
        String startDate = requestVo.getStartDate();
        String endDate = requestVo.getEndDate();
        Map<String, Object> reports = new HashMap<>();
        for(RequestBizCodeVo requestBizCodeVo: requestBizCodeVos) {
            String key = requestBizCodeVo.getKey();
            List<String> bizCodes = requestBizCodeVo.getBizCodes();
            List<ReportBizCodeVo> reportsPerKey = reportService.getReport(startDate, endDate, bizCodes);
            Map<String, List<ReportBizCodeVo>> reportsPerBizCode = reportService.convertReport(reportsPerKey);
            reports.put(key, reportsPerBizCode);
        }

        return ResponseUtil.generateResponse(200,"Success",reports);
    }
}
