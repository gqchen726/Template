package com.template.common;

import org.springframework.http.HttpStatus;

/**
 * @author: guoqing.chen01@hand-china.com 2021-08-22 11:08
 **/

public class ResponseBody<T> {
    private HttpStatus responseCode = HttpStatus.OK;
    private String message = "操作成功";
    private T data;

    public ResponseBody(T data) {
        this.data = data;
    }

    public ResponseBody(HttpStatus responseCode, String message) {
        this.responseCode = responseCode;
        this.message = message;
    }

    public ResponseBody(HttpStatus responseCode, String message, T data) {
        this.responseCode = responseCode;
        this.message = message;
        this.data = data;
    }
}
