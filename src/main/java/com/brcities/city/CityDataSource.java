package com.brcities.city;

import com.brcities.file.FileReader;
import com.brcities.file.parser.FileParser;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CityDataSource {

    private static CityDataSource INSTANCE;

    private List<City> cities;

    private CityDataSource() {
    }

    public static CityDataSource getInstance() {
        if (INSTANCE == null)
            INSTANCE = new CityDataSource();
        return INSTANCE;
    }

    private static Path getFilePath(final String filePath) throws URISyntaxException {
        ClassLoader classLoader = CityDataSource.class.getClassLoader();
        return Paths.get( classLoader.getResource( filePath ).toURI() );
    }

    public void populateFromResourcesFile(final String path, final FileParser parser) throws FileNotFoundException, URISyntaxException {
        FileReader reader = new FileReader( getFilePath( path ) );
        this.cities = parser.parse( reader.read() );
    }

    public List<City> getData() {
        return cities;
    }

}
