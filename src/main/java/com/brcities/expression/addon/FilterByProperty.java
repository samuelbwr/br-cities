package com.brcities.expression.addon;

import com.brcities.facades.EntityFacade;

import java.util.stream.Stream;

public class FilterByProperty implements AddOn {

    private final String property;
    private final String value;
    private final EntityFacade entityFacade;

    public FilterByProperty(String property, String value, EntityFacade entityFacade) {
        this.property = property;
        this.value = value;
        this.entityFacade = entityFacade;
    }

    @Override
    public Stream run(Stream stream) {
        return stream.filter( object -> value.equals( entityFacade
                .getPropertyAsFunction( property )
                .orElseThrow( NoSuchPropertyException::new )
                .apply( object ) ) );
    }
}
