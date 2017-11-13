package com.brcities.city;

import com.brcities.city.model.City;
import com.brcities.dataSource.DataSource;
import com.brcities.file.FileReader;
import com.brcities.file.parser.FileParser;

import java.nio.file.Path;
import java.util.List;

public class CityDataSource implements DataSource<City> {

    private static CityDataSource INSTANCE;

    private List<City> cities;

    private CityDataSource() {
    }

    public static CityDataSource getInstance() {
        if (INSTANCE == null)
            INSTANCE = new CityDataSource();
        return INSTANCE;
    }

    @Override
    public void populateFromFile(final Path path, final FileParser<City> parser) {
        FileReader reader = new FileReader( path );
        this.cities = parser.parse( reader.read() );
    }

    @Override
    public List<City> getData() {
        return cities;
    }

}
