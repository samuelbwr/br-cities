package com.brcities.city;

import com.brcities.facades.EntityFacade;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.AbstractMap.SimpleEntry;
import static java.util.Collections.unmodifiableMap;
import static java.util.stream.Collectors.toMap;

public class CityFacade implements EntityFacade {

    private static CityFacade INSTANCE;

    private static final Map<String, Function> CITY_GETTERS = unmodifiableMap( Stream.of(
            cityPropertyEntry( "ibge_id", (city) -> city.getIbgeId().toString() ),
            cityPropertyEntry( "uf", (city) -> city.getMicroRegion().getMesoRegion().getState().getAbbreviation() ),
            cityPropertyEntry( "name", City::getName ),
            cityPropertyEntry( "capital", (city) -> city.getCapitalAsString() ),
            cityPropertyEntry( "lon", (city) -> city.getLon().toString() ),
            cityPropertyEntry( "lat", (city) -> city.getLat().toString() ),
            cityPropertyEntry( "no_accents", City::getNoAccentName ),
            cityPropertyEntry( "alternative_name", City::getAlternativeName ),
            cityPropertyEntry( "microregion", (city) -> city.getMicroRegion().getName() ),
            cityPropertyEntry( "mesoregion", (city) -> city.getMicroRegion().getMesoRegion().getName() ) )
            .collect( toMap( (e) -> e.getKey(), (e) -> e.getValue() ) ) );

    private static SimpleEntry<String, Function<City, String>> cityPropertyEntry(String key, Function<City, String> value) {
        return new SimpleEntry( key, value );
    }

    private CityFacade() {
    }

    public static CityFacade getInstance(){
        if(INSTANCE == null)
            INSTANCE = new CityFacade();
        return INSTANCE;
    }

    @Override
    public Optional<Function> getPropertyAsFunction(String property) {
        return Optional.ofNullable( CITY_GETTERS.get( property ) );
    }
}
