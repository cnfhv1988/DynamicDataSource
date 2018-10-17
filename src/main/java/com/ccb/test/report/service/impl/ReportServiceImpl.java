package com.ccb.test.report.service.impl;

import com.ccb.test.report.mapper.ReportMapper;
import com.ccb.test.report.service.ReportService;
import com.ccb.test.report.vo.ReportVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("reportService")
public class ReportServiceImpl implements ReportService{

    @Resource
    private ReportMapper reportMapper;

    @Override
    public List<ReportVo> getReport(String startDate, String endDate, String bizCode) {
        return reportMapper.getReport(startDate, endDate, bizCode);
    }
}
