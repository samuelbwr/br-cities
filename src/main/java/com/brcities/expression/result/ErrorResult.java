package com.brcities.expression.result;

public class ErrorResult implements Result<String> {
    private String message;

    public ErrorResult(String message) {
        this.message = message;
    }

    @Override
    public String getValue() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
