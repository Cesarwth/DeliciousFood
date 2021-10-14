package com.atlen.test.hotel.exceptions.enums;

public enum Error {
    VALIDATE_DATE_EXCEPCION("001", "The date of check in could not be the same as date of reservation", "The date of check in could not be the same as date of reservation"),
    VALIDATE_AVAILABILITY_ROOM_EXCEPTION("002", "The Room is not available actually", "Unavailable room"),
    STAY_DAYS_EXCEPTION("003", "The days of stay can not be more than 3 days", "You can not reserve a room for more than 3 days"),
    VALIDATE_LIMIT_DATE_EXCEPCION("004", "The date of check In could not be more than 30 days of the date of reservation", "You can do a reservation with less than 30 days of the date of reservation"),
    DATE_CHECK_AVAILABILITY_EXCEPTION("006", "Date is not available", "Date is not available");

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
