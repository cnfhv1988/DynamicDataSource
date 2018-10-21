package com.ccb.test.report.service;

import com.ccb.test.report.vo.ReportBizCodeVo;

import java.util.List;
import java.util.Map;

public interface ReportService {

    List<ReportBizCodeVo> getReport(String startDate, String endDate, List<String> bizCode);

    Map<String, List<ReportBizCodeVo>> convertReport(List<ReportBizCodeVo> reportBizCodeVos);
}
