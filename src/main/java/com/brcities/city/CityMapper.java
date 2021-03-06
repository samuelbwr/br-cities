package com.brcities.city;

import com.brcities.city.model.City;
import com.brcities.city.model.MesoRegion;
import com.brcities.city.model.MicroRegion;
import com.brcities.city.model.State;
import com.brcities.mappers.EntityMapper;

import java.util.HashMap;
import java.util.Map;

public class CityMapper implements EntityMapper<City> {

    public static CityMapper INSTANCE;

    private Map<String, State> states;
    private Map<String, MicroRegion> microRegions;
    private Map<String, MesoRegion> mesoRegions;

    private CityMapper() {
        states = new HashMap<>();
        microRegions = new HashMap<>();
        mesoRegions = new HashMap<>();
    }

    public static CityMapper getInstance() {
        if (INSTANCE == null)
            INSTANCE = new CityMapper();
        return INSTANCE;
    }

    @Override
    public City fromOrderedStringArray(final String[] values) {
        City city = new City();
        city.setIbgeId( Long.valueOf( values[ 0 ] ) );
        city.setName( values[ 2 ] );
        city.setCapital( Boolean.valueOf( values[ 3 ] ) );
        city.setLon( Double.valueOf( values[ 4 ] ) );
        city.setLat( Double.valueOf( values[ 5 ] ) );
        city.setAlternativeName( values[ 7 ] );
        city.setMicroRegion( getMicroRegion( values ) );
        return city;
    }

    private MicroRegion getMicroRegion(final String[] values) {
        return microRegions.computeIfAbsent( values[ 8 ], n -> new MicroRegion( n, getMesoRegion( values ) ) );
    }

    private MesoRegion getMesoRegion(final String[] values) {
        return mesoRegions.computeIfAbsent( values[ 9 ], n -> new MesoRegion( n, getState( values[ 1 ] ) ) );
    }

    private State getState(final String value) {
        return states.computeIfAbsent( value, State::new );
    }
}
