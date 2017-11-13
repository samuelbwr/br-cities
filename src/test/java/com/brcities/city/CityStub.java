package com.brcities.city;

import com.brcities.city.model.City;
import com.brcities.city.model.MesoRegion;
import com.brcities.city.model.MicroRegion;
import com.brcities.city.model.State;
import com.brcities.dataSource.DataSource;
import com.brcities.file.FileReaderTest;
import com.brcities.file.parser.CsvParser;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public interface CityStub {

    State STATE = new State( "SC" );

    MesoRegion MESO_REGION = new MesoRegion( "MesoRegion", STATE );

    MicroRegion MICRO_REGION = new MicroRegion( "MicroRegion", MESO_REGION  );

    City CITY_ONE = new City( 1l, "City 1", true, 2.3, 3.4, "City one", null ),
            CITY_TWO = new City( 2l, "City 2", true, 1.3, 2.4, "City two", null ),
    FULL_CITY = new City( 1l, "Full City", true, -4.32, 5.21, "Full City name", MICRO_REGION );

    String CITIES_FILE = "small-cidades.csv";

    static DataSource createDefaultDataSource() throws URISyntaxException {
        DataSource dataSource = CityDataSource.getInstance();
        dataSource.populateFromFile( getCitiesFilePath(), new CsvParser( CityMapper.getInstance() ).skippingHeader() );
        return dataSource;
    }

    static Path getCitiesFilePath() throws URISyntaxException {
        ClassLoader classLoader = FileReaderTest.class.getClassLoader();
        return Paths.get( classLoader.getResource( CITIES_FILE ).toURI() );
    }
}
