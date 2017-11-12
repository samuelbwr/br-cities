package com.brcities.expression.addOn;

public class NoSuchPropertyException extends RuntimeException {
    public NoSuchPropertyException() {
        super("Property not found");
    }
}
