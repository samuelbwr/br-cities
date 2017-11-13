package com.brcities.city;

import com.brcities.city.model.City;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CityTest {

    @Test
    public void ensureCanConvertNoAccentName(){
        City city = new City( 1l, "São Sá", false, null, null,null,null );
        assertThat( city.getNoAccentName(), equalTo( "Sao Sa" ) );
    }

    @Test
    public void ensureCanConvertCapitalAsString(){
        City city = new City( 1l, "São Sá", false, null, null,null,null );
        assertThat( city.getCapitalAsString(), equalTo( "false" ) );
    }
}
