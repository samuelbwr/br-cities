package com.brcities.file;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertNotNull;

public class FileReaderTest {

    @Test
    public void ensureCanReadFromFile() throws URISyntaxException, FileNotFoundException {
        FileReader fileReader = new FileReader( getFilePath( "small-cidades.csv" ) );
        BufferedReader reader = fileReader.read();
        assertNotNull( reader );
    }

    private Path getFilePath(String filePath) throws URISyntaxException {
        ClassLoader classLoader = FileReaderTest.class.getClassLoader();
        return Paths.get( classLoader.getResource( filePath ).toURI() );
    }
}
