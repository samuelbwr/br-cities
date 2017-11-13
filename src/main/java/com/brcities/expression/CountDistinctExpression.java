package com.brcities.expression;

import com.brcities.expression.addOn.AddOn;
import com.brcities.expression.result.LongResult;
import com.brcities.expression.result.Result;

import java.util.List;
import java.util.stream.Stream;

public class CountDistinctExpression extends CountExpression {

    private AddOn addOn;

    @Override
    public Result interpret(List context) {
        Stream contextAsStream = context.stream();
        contextAsStream = applyAddOn( contextAsStream );
        return new LongResult( contextAsStream.distinct().count() );
    }

    private Stream applyAddOn(Stream contextStream) {
        if (addOn != null)
            contextStream = addOn.run( contextStream );
        return contextStream;
    }

    public void setAddOn(AddOn addOn) {
        this.addOn = addOn;
    }
}
