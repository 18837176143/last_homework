package com.ypk.common;

public enum ExceptionCodeEunm {
    VALID_FAIL(10000,"参数检验失败"),SUCCESS(20000,"success");

    private int code;
    private String msg;

    ExceptionCodeEunm(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    ExceptionCodeEunm() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
