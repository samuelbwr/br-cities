package com.brcities.expression;

import static com.brcities.CityStub.*;

import com.brcities.city.City;
import com.brcities.city.CityFacade;
import com.brcities.expression.addOn.ByProperty;
import com.brcities.expression.addOn.NoSuchPropertyException;
import com.brcities.expression.result.Result;
import org.junit.Test;

import static java.util.Arrays.asList;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ExpressionTest {

    @Test
    public void ensureCanInterpretCountExpression() {
        List<Integer> list = Arrays.asList( 1, 2 );
        Expression expression = new CountExpression();
        Result result = expression.interpret( list );
        assertThat( result.getValue(), equalTo( 2l ) );
    }

    @Test
    public void ensureCanInterpretCountDistinctExpression() {
        List<Integer> list = Arrays.asList( 1, 2, 2 );
        Expression expression = new CountDistinctExpression();
        Result result = expression.interpret( list );
        assertThat( result.getValue(), equalTo( 2l ) );
    }

    @Test
    public void ensureCanInterpretCountDistinctExpressionByProperty() {
        List<City> list = asList( CITY_ONE, CITY_TWO, CITY_TWO );
        CountDistinctExpression expression = new CountDistinctExpression();
        expression.setAddOn( new ByProperty("ibge_id", null, new CityFacade()) );
        Result result = expression.interpret( list );
        assertThat( result.getValue(), equalTo( 2l ) );
    }

    @Test
    public void ensureCanInterpretFilterExpressionByProperty() {
        List<City> list = asList( CITY_ONE, CITY_TWO, CITY_TWO );
        FilterExpression expression = new FilterExpression();
        expression.setAddOn( new ByProperty("name", "City 2", new CityFacade()) );
        Result<List> result = expression.interpret( list );
        assertThat( result.getValue().size(), equalTo( 2 ) );
        assertThat( ((City)result.getValue().get(0)).getName(), equalTo( CITY_TWO.getName() ) );
    }

    @Test(expected = NoSuchPropertyException.class)
    public void ensureCantInterpretFilterExpressionByInexistentProperty() {
        FilterExpression expression = new FilterExpression();
        expression.setAddOn( new ByProperty("test", "text", new CityFacade()) );
        expression.interpret(asList( CITY_ONE ));
    }
}
