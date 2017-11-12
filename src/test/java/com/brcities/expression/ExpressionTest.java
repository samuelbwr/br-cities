package com.brcities.expression;

import static com.brcities.CityStub.*;

import com.brcities.city.City;
import org.junit.Test;

import static java.util.Arrays.asList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ExpressionTest {

    @Test
    public void ensureCanInterpretCountExpression() {
        List<Integer> list = Arrays.asList( 1, 2 );
        Expression expression = new CountExpression();
        LongResult result = expression.interpret( list );
        assertThat( result.getValue(), equalTo( 2 ) );
    }

    @Test
    public void ensureCanInterpretCountDistinctExpression() {
        List<Integer> list = Arrays.asList( 1, 2, 2 );
        Expression expression = new CountDistinctExpression();
        LongResult result = expression.interpret( list );
        assertThat( result.getValue(), equalTo( 2 ) );
    }

    @Test
    public void ensureCanInterpretCountDistinctExpressionByProperty() {
        List<City> list = asList( CITY_ONE, CITY_TWO, CITY_TWO );
        Expression expression = new CountDistinctExpression();
        expression.addAddon( new ByProperty("ibge_id") );
        LongResult result = expression.interpret( list );
        assertThat( result.getValue(), equalTo( 3 ) );
    }

    @Test
    public void ensureCanInterpretFilterExpression() {
        List<Integer> list = asList( 1, 2, 2 );
        Expression expression = new FilterExpression( 1 );
        ListResult result = expression.interpret( list );
        assertThat( result.getValue().size(), equalTo( 1 ) );
        assertThat( result.getValue().get(0), equalTo( 1 ) );
    }

    @Test
    public void ensureCanInterpretFilterExpressionByProperty() {
        List<City> list = asList( CITY_ONE, CITY_TWO, CITY_TWO );
        Expression expression = new FilterExpression( CITY_TWO.getName() );
        expression.addAddon(new ByProperty("name"));
        ListResult result = expression.interpret( list );
        assertThat( result.getValue().size(), equalTo( 2 ) );
        assertThat( result.getValue().get(0), equalTo( CITY_TWO.getName() ) );
    }

    @Test(NoSuchPropertyException.class)
    public void ensureCantInterpretFilterExpressionByInexistentProperty() {
        Expression expression = new FilterExpression( "text" );
        expression.addAddon(new ByProperty("test"));
        expression.interpret(asList( CITY_ONE ));
    }
}
