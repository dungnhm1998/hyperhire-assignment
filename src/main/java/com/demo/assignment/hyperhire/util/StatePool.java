package com.demo.assignment.hyperhire.util;

public enum StatePool {
    DELETED("deleted", "deleted"),
    AVAILABLE("available", "available"),
    SOLD_OUT("sold_out", "sold out");

    private String code;
    private String value;

    StatePool(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
