package com.brcities.expression;

import com.brcities.expression.addon.AddOn;
import com.brcities.expression.result.LongResult;
import com.brcities.expression.result.Result;

import java.util.List;
import java.util.stream.Stream;

public class CountDistinctExpression extends CountExpression {

    private AddOn addOn;

    @Override
    public Result interpret(final List context) {
        Stream contextAsStream = applyAddOn( context.stream() );
        return new LongResult( contextAsStream.distinct().count() );
    }

    public Stream applyAddOn(final Stream contextStream) {
        if (addOn != null)
            return addOn.run( contextStream );
        return contextStream;
    }

    public void setAddOn(final AddOn addOn) {
        this.addOn = addOn;
    }
}
