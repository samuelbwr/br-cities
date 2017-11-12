package com.brcities.city;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CityTest {

    @Test
    public void ensureCanCreateNoAccentName(){
        City city = new City( 1l, "São Sá", false, null, null,null,null );
        assertThat( city.getNoAccentName(), equalTo( "Sao Sa" ) );
    }
}