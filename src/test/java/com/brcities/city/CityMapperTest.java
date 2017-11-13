package com.brcities.city;

import org.junit.Test;

import static com.brcities.city.CityStub.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CityMapperTest {

    @Test
    public void ensureCanCreateInstanceFromMap() {
        String[] values = { "1", "SC", "Full City", "false","5.21","-4.32","Full City","Full City name" ,"MicroRegion", "MesoRegion" };
        CityMapper mapper = CityMapper.getInstance();
        City city = mapper.fromOrderedStringArray( values );
        assertCity( city );
    }

    private void assertCity(City city) {
        assertThat( city.getIbgeId(), equalTo( FULL_CITY.getIbgeId() ) );
        assertThat( city.getMicroRegion().getMesoRegion().getState().getAbbreviation(), equalTo( STATE.getAbbreviation() ) );
        assertThat( city.getMicroRegion().getMesoRegion().getName(), equalTo( MESO_REGION.getName() ) );
        assertThat( city.getMicroRegion().getName(), equalTo( MICRO_REGION.getName() ) );
        assertThat( city.getName(), equalTo( FULL_CITY.getName() ) );
        assertThat( city.isCapital(), equalTo( FULL_CITY.isCapital() ) );
        assertThat( city.getLat(), equalTo( FULL_CITY.getLat() ) );
        assertThat( city.getLon(), equalTo( FULL_CITY.getLon() ) );
        assertThat( city.getNoAccentName(), equalTo( FULL_CITY.getNoAccentName() ) );
        assertThat( city.getAlternativeName(), equalTo( FULL_CITY.getAlternativeName() ) );
    }
}
