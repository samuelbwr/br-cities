package com.brcities.expression;

import com.brcities.expression.result.LongResult;
import com.brcities.expression.result.Result;

import java.util.List;

public class CountExpression implements Expression {
    @Override
    public Result interpret(final List context) {
        return new LongResult(context.size());
    }
}
