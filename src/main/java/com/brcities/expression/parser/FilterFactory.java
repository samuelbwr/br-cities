package com.brcities.expression.parser;

import com.brcities.city.CityFacade;
import com.brcities.expression.Expression;
import com.brcities.expression.FilterExpression;
import com.brcities.expression.addon.FilterByProperty;

import java.util.List;

public class FilterFactory {

    public static Expression getInstance(final List<String> params) {
        return createFilterByPropertyExpression( params );
    }

    private static Expression createFilterByPropertyExpression(final List<String> params) {
        FilterExpression expression = new FilterExpression();
        expression.setAddOn( new FilterByProperty( params.remove( 0 ), joinRemainingParams( params ), CityFacade.getInstance() ) );
        return expression;
    }

    private static String joinRemainingParams(final List<String> params) {
        return String.join( " ", params );
    }
}
