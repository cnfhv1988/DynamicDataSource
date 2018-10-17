package com.ccb.test.report.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponseUtil {

    private static final Logger logger = LoggerFactory.getLogger(ResponseUtil.class);

    public static CommonResponse generateResponse(int code, String message, Object data) {
        CommonResponse response = new CommonResponse();
        response.setCode(code).setMessage(message).setData(data);
        return response;
    }

}
