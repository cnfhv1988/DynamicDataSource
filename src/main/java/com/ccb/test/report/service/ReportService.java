package com.ccb.test.report.service;

import com.ccb.test.report.vo.ReportVo;

import java.util.List;

public interface ReportService {

    List<ReportVo> getReport(String startDate, String endDate, String bizCode);
}
