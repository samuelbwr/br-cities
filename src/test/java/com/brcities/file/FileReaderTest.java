package com.brcities.file;

import com.brcities.city.City;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class FileReaderTest {

    @Test
    public void ensureCanReadFromFile(){
        FileReader fileReader = new CsvFileReader(getFilePath( "small-cidades.csv" ),
                new CsvConfigs(new CsvFileParser(new CityMapper()), false));
        List<City> cities = fileReader.read();
        assertThat( cities.size(), equalTo( 3l ) );
    }

    @Test(expected = FileTypeNotSupported.class)
    public void ensureCantReadUnsupportedFile(){
        FileReader fileReader = new CsvFileReader(getFilePath( "unsupported.txt" ), null);
        fileReader.read();
    }

    private InputStream getFilePath(String filePath) {
        ClassLoader classLoader = FileReaderTest.class.getClassLoader();
        return classLoader.getResourceAsStream( filePath );
    }
}
