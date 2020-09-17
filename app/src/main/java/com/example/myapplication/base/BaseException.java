package com.example.myapplication.base;

import java.io.IOException;


public class BaseException extends IOException {

    /**
     * 解析数据失败
     */
    public static final String PARSE_ERROR = "1001";
    public static final String PARSE_ERROR_MSG = "解析数据失败";

    /**
     * 网络问题
     */
    public static final String BAD_NETWORK = "1002";
    public static final String BAD_NETWORK_MSG = "网络问题";
    /**
     * 连接错误
     */
    public static final String CONNECT_ERROR = "1003";
    public static final String CONNECT_ERROR_MSG = "连接错误";
    /**
     * 连接超时
     */
    public static final String CONNECT_TIMEOUT = "1004";
    public static final String CONNECT_TIMEOUT_MSG = "连接超时";
    /**
     * 未知错误
     */
    public static final String OTHER = "1005";
    public static final String OTHER_MSG = "未知错误";
    public static final String TOKEN = "0000";
    public static final String TOKEN_MSG = "登录失效";
    public static final String SERVER = "-1";
    public static final String SERVER_MSG = "服务器开小差啦-。-";
    public static final String SERVER_MSG_ENG = "server exception-。-";
    public static final String GROUP_DISS = "-2";

    private String errorMsg;
    private String errorCode;


    public String getErrorMsg() {
        return errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public BaseException(String errorMsg, Throwable cause) {
        super(errorMsg, cause);
        this.errorMsg = errorMsg;
    }

    public BaseException(String message, Throwable cause, String errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
        this.errorMsg = message;
    }

    public BaseException(String message, String errorCode) {
        this.errorCode = errorCode;
        this.errorMsg = message;
    }
}
