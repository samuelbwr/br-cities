package com.brcities.city;

import com.brcities.file.FileReader;
import com.brcities.file.parser.CsvParser;
import com.brcities.file.parser.FileParser;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CityDao {
    private static CityDao INSTANCE;

    List<City> cities;

    private CityDao() {
    }

    public static CityDao getInstance() {
        if (INSTANCE == null)
            INSTANCE = new CityDao();
        return INSTANCE;
    }

    private static Path getFilePath(String filePath) throws URISyntaxException {
        ClassLoader classLoader = CityDao.class.getClassLoader();
        return Paths.get( classLoader.getResource( filePath ).toURI() );
    }

    public void populateFromResourceFile(String path) throws FileNotFoundException, URISyntaxException {
        FileReader reader = new FileReader( getFilePath( path ) );
        FileParser parser = new CsvParser( reader.read(), CityMapper.getInstance() ).skippingHeader();
        this.cities = parser.parse();
    }

    public List<City> getData() {
        return cities;
    }

}
