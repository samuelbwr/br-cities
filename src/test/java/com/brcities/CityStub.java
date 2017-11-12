package com.brcities;

import com.brcities.city.City;

public interface CityStub {

    City CITY_ONE = new City( 1l, "City 1", true, 2.3, 3.4, "City one", null ),
            CITY_TWO = new City( 2l, "City 2", true, 1.3, 2.4, "City two", null );
}
