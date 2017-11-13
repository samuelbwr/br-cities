package com.brcities.file;

import com.brcities.city.CityStub;
import org.junit.Test;

import java.io.BufferedReader;
import java.net.URISyntaxException;

import static org.junit.Assert.assertNotNull;

public class FileReaderTest {

    @Test
    public void ensureCanReadFromFile() throws URISyntaxException {
        FileReader fileReader = new FileReader( CityStub.CITIES_FILE );
        BufferedReader reader = fileReader.read();
        assertNotNull( reader );
    }
}
