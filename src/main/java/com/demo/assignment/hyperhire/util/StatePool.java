package com.demo.assignment.hyperhire.util;

public enum StatePool {
    DELETED(-1, "deleted"),
    AVAILABLE(1, "available"),
    SOLD_OUT(0, "sold out");

    private int code;
    private String value;

    StatePool(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
