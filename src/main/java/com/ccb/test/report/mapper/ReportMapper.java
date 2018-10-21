package com.ccb.test.report.mapper;

import com.ccb.test.report.vo.ReportBizCodeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReportMapper {
    List<ReportBizCodeVo> getReport(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("bizCodes") List<String> bizCodes);
}
