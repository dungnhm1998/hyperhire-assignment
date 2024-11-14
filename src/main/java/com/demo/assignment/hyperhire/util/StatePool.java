package com.demo.assignment.hyperhire.util;

public enum StatePool {
    AVAILABLE("available", "available"),
    CANCELLED("cancelled", "cancelled"),
    SOLD_OUT("sold_out", "sold out"),

    CREATED("created", "created"),
    APPROVED("approved", "approved"),
    REFUNDED("refunded", "refunded"),
    FAILED("failed", "failed"),
    PENDING("pending", "pending"),

    DELETED("deleted", "deleted");

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
