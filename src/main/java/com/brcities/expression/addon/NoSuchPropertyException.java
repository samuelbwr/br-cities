package com.brcities.expression.addon;

public class NoSuchPropertyException extends RuntimeException {
    public NoSuchPropertyException() {
        super("Property not found");
    }
}
