package com.brcities.expression.addOn;

import com.brcities.facades.EntityFacade;

import java.util.stream.Stream;

public class ByProperty implements AddOn{

    private String property;
    private String value;
    private EntityFacade entityFacade;

    public ByProperty(String property, String value, EntityFacade entityFacade) {
        this.property = property;
        this.value = value;
        this.entityFacade = entityFacade;
    }

    @Override
    public Stream filter(Stream stream) {
        return stream.filter( object -> value.equals( entityFacade
                .getPropertyAsFunction(property).orElseThrow( NoSuchPropertyException::new ).apply( object ) ) );
    }

    @Override
    public Stream map(Stream stream){
        return stream.map( entityFacade.getPropertyAsFunction( property ).orElseThrow( NoSuchPropertyException::new )  );
    }
}
