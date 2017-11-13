package com.brcities.file;

import com.brcities.city.model.City;
import com.brcities.file.parser.CsvParser;
import com.brcities.file.parser.FileParser;
import com.brcities.city.CityMapper;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertThat;

public class FileParserTest {

    @Test
    public void ensureCanParseCity() throws URISyntaxException, FileNotFoundException {
        FileParser fileParser = new CsvParser( CityMapper.getInstance() ).skippingHeader();
        List<City> cities = fileParser.parse( createReader() );
        assertThat( cities.size(), equalTo( 3 ) );
    }

    @Test(expected = NumberFormatException.class)
    public void ensureCanKeepTheHeader() throws URISyntaxException, FileNotFoundException {
        FileParser fileParser = new CsvParser( CityMapper.getInstance() );
        fileParser.parse( createReader() );
    }

    private BufferedReader createReader() throws URISyntaxException, FileNotFoundException {
        return new FileReader( getFilePath( "small-cidades.csv" ) ).read();
    }

    private Path getFilePath(String filePath) throws URISyntaxException {
        ClassLoader classLoader = FileReaderTest.class.getClassLoader();
        return Paths.get( classLoader.getResource( filePath ).toURI() );
    }
}
