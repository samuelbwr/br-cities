package com.brcities.expression.addOn;

import com.brcities.facades.EntityFacade;

import java.util.stream.Stream;

public class MapByProperty implements AddOn{

    private final String property;
    private final EntityFacade entityFacade;

    public MapByProperty(String property, EntityFacade entityFacade) {
        this.property = property;
        this.entityFacade = entityFacade;
    }

    @Override
    public Stream run(Stream stream){
        return stream.map( entityFacade.getPropertyAsFunction( property ).orElseThrow( NoSuchPropertyException::new )  );
    }
}
