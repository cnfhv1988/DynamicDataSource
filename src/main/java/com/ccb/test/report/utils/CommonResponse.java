package com.ccb.test.report.utils;

public class CommonResponse {

    private int code;
    private String message;
    private Object data;

    public int getCode() {
        return code;
    }

    public CommonResponse setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CommonResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public CommonResponse setData(Object data) {
        this.data = data;
        return this;
    }
}
