package com.bank.springboot.until;

public enum ResponseCodeEnum {
    SUCCESS("00000", "Successful."),
    FAIL("00001", "Failure."),
    INSUFFICIENT_BALANCE("00002", "Insufficient Balance.");

    private final String code;
    private final String description;

    private ResponseCodeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }

}
