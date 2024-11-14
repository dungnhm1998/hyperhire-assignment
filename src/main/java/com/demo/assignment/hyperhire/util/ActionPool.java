package com.demo.assignment.hyperhire.util;

public enum ActionPool {
    APPROVE("approve", "approve"),
    DENY("deny", "deny");

    private String code;
    private String value;

    ActionPool(String code, String value) {
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
