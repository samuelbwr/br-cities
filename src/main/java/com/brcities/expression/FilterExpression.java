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
    public Result interpret(final List context) {
        Stream contextAsStream = applyAddOn( context.stream() );
        return new ListResult( (List) contextAsStream.collect( Collectors.toList() ) );
    }

    public Stream applyAddOn(final Stream contextAsStream) {
        if (addOn != null)
            return addOn.run( contextAsStream );
        return contextAsStream;
    }

    public void setAddOn(final AddOn addOn) {
        this.addOn = addOn;
    }
}
