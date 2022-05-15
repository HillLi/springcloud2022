package com.jialin.practice.cloud.order.entities;

public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommonResult() {
    }

    public static <T> CommonResult SUCCESS() {
        return new CommonResult(200, "操作成功", null);
    }

    public static <T> CommonResult SUCCESS(T data) {
        return new CommonResult(200, "操作成功", data);
    }

    public static <T> CommonResult SUCCESS(String message, T data) {
        return new CommonResult(200, message, data);
    }

    public static <T> CommonResult ERROR(String message) {
        return new CommonResult(400, message);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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
