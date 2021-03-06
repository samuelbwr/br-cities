package com.brcities.expression.result;

import java.util.List;

public class ListResult<T> implements Result<List<T>> {
    private List<T> value;

    public ListResult(List<T> value) {
        this.value = value;
    }

    @Override
    public List<T> getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringBuilder valueInString = new StringBuilder();
        for (T item : value) {
            valueInString.append( item.toString() );
            valueInString.append( "\n" );
        }
        return valueInString.toString();
    }

}
