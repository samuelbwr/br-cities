package com.brcities.expression.parser;

import com.brcities.city.CityFacade;
import com.brcities.expression.Expression;
import com.brcities.expression.FilterExpression;
import com.brcities.expression.addOn.FilterByProperty;

import java.util.List;

public class FilterFactory {

    public static Expression getInstance(List<String> params) {
        return createFilterByPropertyExpression( params );
    }

    private static Expression createFilterByPropertyExpression(List<String> params) {
        FilterExpression expression = new FilterExpression();
        expression.setAddOn( new FilterByProperty( params.get( 0 ), params.get( 1 ), CityFacade.getInstance() ) );
        return expression;
    }
}
