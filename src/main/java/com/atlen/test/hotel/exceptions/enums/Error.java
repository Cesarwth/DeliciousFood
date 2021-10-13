package com.atlen.test.hotel.exceptions.enums;

public enum Error {
    VALIDATE_DATE_EXCEPCION("001", "The date of check In could not be the same Day of reservation"),
    VALIDATE_AVAILABILITY_ROOM_EXCEPTION("002", "The Room is not available actually"),
    STAY_DAYS_EXCEPTION("003", "The days of stay can not be more than 3 days", "Review Dates of check In and Check Out"),
    VALIDATE_LIMIT_DATE_EXCEPCION("004", "The date of check In could not be more than 30 days of the date of reservation");

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
