package com.brcities.expression;

import com.brcities.city.CityFacade;
import com.brcities.city.model.City;
import com.brcities.expression.addon.FilterByProperty;
import com.brcities.expression.addon.MapByProperty;
import com.brcities.expression.addon.NoSuchPropertyException;
import com.brcities.expression.result.Result;
import org.junit.Test;

import java.util.List;

import static com.brcities.city.CityStub.CITY_ONE;
import static com.brcities.city.CityStub.CITY_TWO;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ExpressionTest {

    @Test
    public void ensureCanInterpretCountExpression() {
        List<Integer> list = asList( 1, 2 );
        Expression expression = new CountExpression();
        Result result = expression.interpret( list );
        assertThat( result.getValue(), equalTo( 2l ) );
    }

    @Test
    public void ensureCanInterpretCountDistinctExpression() {
        List<Integer> list = asList( 1, 2, 2 );
        Expression expression = new CountDistinctExpression();
        Result result = expression.interpret( list );
        assertThat( result.getValue(), equalTo( 2l ) );
    }

    @Test
    public void ensureCanInterpretCountDistinctExpressionByProperty() {
        List<City> list = asList( CITY_ONE, CITY_TWO, CITY_TWO );
        CountDistinctExpression expression = new CountDistinctExpression();
        expression.setAddOn( new MapByProperty( "ibge_id", CityFacade.getInstance() ) );
        Result result = expression.interpret( list );
        assertThat( result.getValue(), equalTo( 2l ) );
    }

    @Test
    public void ensureCanInterpretFilterExpressionByProperty() {
        List<City> list = asList( CITY_ONE, CITY_TWO, CITY_TWO );
        FilterExpression expression = new FilterExpression();
        expression.setAddOn( new FilterByProperty( "name", "City 2", CityFacade.getInstance() ) );
        Result<List> result = expression.interpret( list );
        assertThat( result.getValue().size(), equalTo( 2 ) );
        assertThat( ((City) result.getValue().get( 0 )).getName(), equalTo( CITY_TWO.getName() ) );
    }

    @Test(expected = NoSuchPropertyException.class)
    public void ensureCantInterpretFilterExpressionByInexistentProperty() {
        FilterExpression expression = new FilterExpression();
        expression.setAddOn( new FilterByProperty( "test", "text", CityFacade.getInstance() ) );
        expression.interpret( asList( CITY_ONE ) );
    }
}
