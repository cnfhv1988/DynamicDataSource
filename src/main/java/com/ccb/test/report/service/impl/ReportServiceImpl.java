package com.ccb.test.report.service.impl;

import com.ccb.test.report.mapper.ReportMapper;
import com.ccb.test.report.service.ReportService;
import com.ccb.test.report.vo.ReportBizCodeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("reportService")
public class ReportServiceImpl implements ReportService{

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public List<ReportBizCodeVo> getReport(String startDate, String endDate, List<String> bizCodes) {
        return reportMapper.getReport(startDate, endDate, bizCodes);
    }

    @Override
    public Map<String, List<ReportBizCodeVo>> convertReport(List<ReportBizCodeVo> reportBizCodeVos) {
        Map<String, List<ReportBizCodeVo>> reports = new HashMap<>();

        for(ReportBizCodeVo reportBizCodeVo: reportBizCodeVos) {
            if(!reports.containsKey(reportBizCodeVo.getBizCode())) {
                reports.put(reportBizCodeVo.getBizCode(),new ArrayList<>());
            }
            reports.get(reportBizCodeVo.getBizCode()).add(reportBizCodeVo);

        }
        return reports;
    }
}
