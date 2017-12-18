package com.brcities.expression.parser;

import com.brcities.expression.Expression;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.Collections.unmodifiableMap;
import static java.util.stream.Collectors.toMap;

public class ExpressionParser {

    private static ExpressionParser INSTANCE;

    private static final Map<String, Function> FIRST_COMMAND = unmodifiableMap( Stream.of(
            commandEntry( "count", CountFactory::getInstance ),
            commandEntry( "filter", FilterFactory::getInstance ) )
            .collect( toMap( (e) -> e.getKey(), (e) -> e.getValue() ) ) );

    private static AbstractMap.SimpleEntry<String, Function<List<String>, Expression>> commandEntry(
            String key, Function<List<String>, Expression> value) {
        return new AbstractMap.SimpleEntry( key, value );
    }

    private ExpressionParser() {
    }

    public static ExpressionParser getInstance(){
        if(INSTANCE == null)
            INSTANCE = new ExpressionParser();
        return INSTANCE;
    }

    public Expression parse(final String command) {
        List<String> splittedCommand = toList(command.split( " " ));
        final Function commandFunction = FIRST_COMMAND.get( splittedCommand.get( 0 ) );
        if(commandFunction == null)
            throw new ParseException("Command '"+splittedCommand.get( 0 )+"' not implemented");
        splittedCommand.remove( 0 );
        return (Expression) commandFunction.apply(splittedCommand);
    }

    private List<String> toList(final String[] array) {
        final List<String> list = new ArrayList<>();
        for (String item : array)
            list.add( item );
        return list;
    }

}
