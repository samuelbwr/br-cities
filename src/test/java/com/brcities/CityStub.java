package com.brcities;

import com.brcities.city.City;
import com.brcities.city.MesoRegion;
import com.brcities.city.MicroRegion;
import com.brcities.city.State;

public interface CityStub {

    State STATE = new State( "SC" );

    MesoRegion MESO_REGION = new MesoRegion( "MesoRegion", STATE );

    MicroRegion MICRO_REGION = new MicroRegion( "MicroRegion", MESO_REGION  );

    City CITY_ONE = new City( 1l, "City 1", true, 2.3, 3.4, "City one", null ),
            CITY_TWO = new City( 2l, "City 2", true, 1.3, 2.4, "City two", null ),
    FULL_CITY = new City( 1l, "Full City", false, -4.32, 5.21, "Full City name", MICRO_REGION );
}
