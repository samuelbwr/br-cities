package com.brcities.expression;

import com.brcities.expression.result.Result;

import java.util.List;

public interface Expression {

    Result interpret(List context);
}
