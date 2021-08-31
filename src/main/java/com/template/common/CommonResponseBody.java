package com.template.common;

import org.springframework.http.HttpStatus;

/**
 * @author: guoqing.chen01@hand-china.com 2021-08-22 11:08
 **/

public class CommonResponseBody<T> {
    private HttpStatus responseCode = HttpStatus.OK;
    private String message = "操作成功";
    private T data;

    public CommonResponseBody(T data) {
        this.data = data;
    }

    public CommonResponseBody(HttpStatus responseCode, String message) {
        this.responseCode = responseCode;
        this.message = message;
    }

    public CommonResponseBody(HttpStatus responseCode, String message, T data) {
        this.responseCode = responseCode;
        this.message = message;
        this.data = data;
    }

    public HttpStatus getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(HttpStatus responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
