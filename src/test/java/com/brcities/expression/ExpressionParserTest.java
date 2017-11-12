package com.brcities.expression;

import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.instanceOf;

import com.brcities.expression.parser.ExpressionParser;
import com.brcities.expression.parser.ParseException;
import org.junit.Test;

public class ExpressionParserTest {

    @Test
    public void ensureCanParseCountAllCommand(){
        ExpressionParser parser = new ExpressionParser();
        Expression expression = parser.parse("count *");
        assertThat( expression, instanceOf( CountExpression.class ) );
    }

    @Test
    public void ensureCanParseCountDistinctCommand(){
        ExpressionParser parser = new ExpressionParser();
        Expression expression = parser.parse("count distinct state");
        assertThat( expression, instanceOf( CountDistinctExpression.class ) );
    }

    @Test
    public void ensureCanParseFilterCommand(){
        ExpressionParser parser = new ExpressionParser();
        Expression expression = parser.parse("filter name City");
        assertThat( expression, instanceOf( FilterExpression.class ) );
    }

    @Test(expected = ParseException.class)
    public void ensureCantParseInvalidCommand(){
        ExpressionParser parser = new ExpressionParser();
        Expression expression = parser.parse("add city");
    }

}
