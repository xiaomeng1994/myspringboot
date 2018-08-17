package com.meng.commnon;

/**
 * 返回信息主体类
 */
public class ReturnMessage {
    private int code = 200;//默认200成功
    private String message = "操作成功";//默认操作成功

    public ReturnMessage() {
    }

    public ReturnMessage(int code) {
        this.code = code;
    }

    public ReturnMessage(String message) {
        this.message = message;
    }

    public ReturnMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
