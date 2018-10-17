package com.ccb.test.report.mapper;

import com.ccb.test.report.vo.ReportVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReportMapper {
    List<ReportVo> getReport(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("bizCode") String bizCode);
}
