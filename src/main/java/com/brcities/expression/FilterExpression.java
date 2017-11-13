package com.brcities.expression;

import com.brcities.expression.addOn.AddOn;
import com.brcities.expression.result.ListResult;
import com.brcities.expression.result.Result;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterExpression implements Expression {

    private AddOn addOn;

    @Override
    public Result interpret(List context) {
        Stream contextAsStream = context.stream();
        contextAsStream = applyAddOn( contextAsStream );
        return new ListResult( (List) contextAsStream.collect( Collectors.toList() ) );
    }

    private Stream applyAddOn(Stream contextAsStream) {
        if (addOn != null)
            contextAsStream = addOn.run( contextAsStream );
        return contextAsStream;
    }

    public void setAddOn(AddOn addOn) {
        this.addOn = addOn;
    }
}
