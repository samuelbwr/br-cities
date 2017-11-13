package com.brcities.expression.parser;

import com.brcities.city.CityFacade;
import com.brcities.expression.CountDistinctExpression;
import com.brcities.expression.CountExpression;
import com.brcities.expression.Expression;
import com.brcities.expression.addon.MapByProperty;

import java.util.List;

public class CountFactory {

    public static Expression getInstance(final List<String> params) {
        if ("*".equals( params.get( 0 ) ))
            return new CountExpression();
        else {
            return createCountDistinctExpression( params );
        }
    }

    private static Expression createCountDistinctExpression(final List<String> params) {
        CountDistinctExpression expression = new CountDistinctExpression();
        expression.setAddOn( new MapByProperty( params.get( 1 ), CityFacade.getInstance() ) );
        return expression;
    }
}
