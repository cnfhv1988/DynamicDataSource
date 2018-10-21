package com.ccb.test.report.vo;

import java.util.List;

public class RequestBizCodeVo {

    private String key;
    private List<String> bizCodes;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getBizCodes() {
        return bizCodes;
    }

    public void setBizCodes(List<String> bizCodes) {
        this.bizCodes = bizCodes;
    }
}
