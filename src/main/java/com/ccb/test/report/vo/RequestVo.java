package com.ccb.test.report.vo;

import java.util.List;

public class RequestVo {

    private String env;
    private String startDate;
    private String endDate;
    private List<RequestBizCodeVo> transCodes;

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<RequestBizCodeVo> getTransCodes() {
        return transCodes;
    }

    public void setTransCodes(List<RequestBizCodeVo> transCodes) {
        this.transCodes = transCodes;
    }
}
