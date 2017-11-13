package com.brcities.city;

import static com.brcities.city.CityStub.*;

import com.brcities.expression.addOn.NoSuchPropertyException;
import org.junit.Test;

import java.util.function.Function;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CityFacadeTest {

    @Test
    public void ensureCanGetRightProperty(){
        CityFacade cityFacade = CityFacade.getInstance();
        Function propertyFunction = cityFacade.getPropertyAsFunction( "name" ).get();
        String name = String.valueOf( propertyFunction.apply( CITY_ONE ) );
        assertThat( CITY_ONE.getName(), equalTo( name ) );
    }

    @Test(expected = NoSuchPropertyException.class)
    public void ensureCantGetInexistentProperty(){
        CityFacade cityFacade = CityFacade.getInstance();
        cityFacade.getPropertyAsFunction( "teste" ).orElseThrow( NoSuchPropertyException::new );
    }
}
