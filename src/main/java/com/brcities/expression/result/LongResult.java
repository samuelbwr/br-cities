package com.brcities.expression.result;

public class LongResult implements Result<Long> {
    long value;

    public LongResult(long value) {
        this.value = value;
    }

    @Override
    public Long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return  String.valueOf( value );
    }

}
