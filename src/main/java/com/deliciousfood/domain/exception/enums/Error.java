package com.deliciousfood.domain.exception.enums;

public enum Error {
    VALIDATE_DATE_EXCEPCION("001", "The date of check in could not be the same as date of reservation", "The date of check in could not be the same as date of reservation");

    private final String code;
    private final String developerMessage;
    private final String userMessage;

    Error(String code, String developerMessage, String userMessage) {
        this.code = code;
        this.developerMessage = developerMessage;
        this.userMessage = userMessage;
    }

    Error(String code, String userMessage) {
        this.code = code;
        this.developerMessage = "";
        this.userMessage = userMessage;
    }

    public String getCode() {
        return code;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public String getUserMessage() {
        return userMessage;
    }
}
