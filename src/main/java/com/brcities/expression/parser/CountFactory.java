package com.brcities.expression.parser;

import com.brcities.city.CityFacade;
import com.brcities.expression.CountDistinctExpression;
import com.brcities.expression.CountExpression;
import com.brcities.expression.Expression;
import com.brcities.expression.addOn.ByProperty;

import java.util.List;

public class CountFactory {

    public static Expression getInstance(List<String> params){
        if("*".equals( params.get( 0 )))
            return new CountExpression();
        else {
            return createCountDistinctExpression( params );
        }
    }

    private static Expression createCountDistinctExpression(List<String> params) {
        CountDistinctExpression expression = new CountDistinctExpression();
        expression.setAddOn( new ByProperty( params.get( 0 ), params.get( 1 ), new CityFacade() ) );
        return expression;
    }
}
