package com.brcities.file;

import com.brcities.city.City;
import com.brcities.file.parser.CsvParser;
import com.brcities.file.parser.FileParser;
import com.brcities.mappers.CityMapper;
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
        FileParser fileParser = new CsvParser( createReader(), CityMapper.getInstance() ).skippingHeader();
        List<City> cities = fileParser.parse();
        assertThat( cities.size(), equalTo( 3 ) );
    }

    @Test(expected = NumberFormatException.class)
    public void ensureThrowErrorIfNotRemoveHeader() throws URISyntaxException, FileNotFoundException {
        FileParser fileParser = new CsvParser( createReader(), CityMapper.getInstance() );
        fileParser.parse();
    }

    private BufferedReader createReader() throws URISyntaxException, FileNotFoundException {
        return new FileReader( getFilePath( "small-cidades.csv" ) ).read();
    }

    private Path getFilePath(String filePath) throws URISyntaxException {
        ClassLoader classLoader = FileReaderTest.class.getClassLoader();
        return Paths.get( classLoader.getResource( filePath ).toURI() );
    }
}
