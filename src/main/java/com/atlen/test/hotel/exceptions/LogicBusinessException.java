package com.atlen.test.hotel.exceptions;

import com.atlen.test.hotel.exceptions.enums.Error;
public class LogicBusinessException extends RuntimeException {

    private Error error;

    public LogicBusinessException(Error error) {
        super(error.getDeveloperMessage());
        this.error = error;
    }

    public Error getError() {
        return error;
    }
}
