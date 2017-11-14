package com.brcities.city;

import com.brcities.city.model.City;
import com.brcities.datasource.DataSource;
import com.brcities.expression.Expression;
import com.brcities.expression.addon.NoSuchPropertyException;
import com.brcities.expression.parser.ExpressionParser;
import com.brcities.expression.parser.ParseException;
import com.brcities.expression.result.ErrorResult;
import com.brcities.expression.result.Result;

public class CityService {

    private final DataSource<City> dataSource;

    public CityService(final DataSource<City> dataSource) {
        this.dataSource = dataSource;
    }

    public Result runCommand(final String command) {
        try {
            return interpretExpression( parseCommandToExpression( command ) );
        } catch (ParseException | NoSuchPropertyException e) {
            return new ErrorResult( e.getMessage() );
        }
    }

    private Expression parseCommandToExpression(final String command) {
        return ExpressionParser.getInstance().parse( command );
    }

    private Result interpretExpression(final Expression expression) {
        return expression.interpret( dataSource.getData() );
    }
}
