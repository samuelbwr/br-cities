package com.brcities.file;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertNotNull;

public class FileReaderTest {
    private static final String CITIES_FILE = "small-cidades.csv";

    @Test
    public void ensureCanReadFromFile() throws URISyntaxException {
        FileReader fileReader = new FileReader( getFilePath( CITIES_FILE ) );
        BufferedReader reader = fileReader.read();
        assertNotNull( reader );
    }

    private Path getFilePath(String filePath) throws URISyntaxException {
        ClassLoader classLoader = FileReaderTest.class.getClassLoader();
        return Paths.get( classLoader.getResource( filePath ).toURI() );
    }
}
