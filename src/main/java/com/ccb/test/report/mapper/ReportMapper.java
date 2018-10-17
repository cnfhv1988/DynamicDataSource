package com.ccb.test.report.mapper;

import com.ccb.test.report.vo.ReportVo;

import java.util.List;

public interface ReportMapper {
    List<ReportVo> getReport(String startDate, String endDate, String bizCode);
}
