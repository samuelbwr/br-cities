package com.brcities.city;
import static com.brcities.CityStub.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CityMapperTest {

    @Test
    public void ensureCanCreateInstanceFromMap(){
        Map<String, String> values = new HashMap<>(  );
        values.put( "ibge_id",  "1" );
        values.put( "name",  "Full City" );
        values.put( "mesoregion", "MesoRegion");
        values.put( "microregion", "MicroRegion");
        values.put( "uf", "SC");
        values.put( "capital", "false");
        values.put( "lat", "-4.32");
        values.put( "lon", "5.21");
        values.put( "alternative_names", "Full City name");
        values.put( "no_accents", "Full City");
        EntityMapper mapper = CityMapper.getInstance();
        City city = mapper.fromMap(values);
        assertCity( city );
    }

    private void assertCity(City city){
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
