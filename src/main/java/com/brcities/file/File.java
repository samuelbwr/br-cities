package com.brcities.file;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class File {

    public static Path fromResource(String path) throws FileNotFoundException {
        try {
            return getFilePath( path );
        } catch (URISyntaxException e) {
            throw new FileNotFoundException( "The file was not found" );
        }
    }

    private static Path getFilePath(String filePath) throws URISyntaxException {
        ClassLoader classLoader = File.class.getClassLoader();
        return Paths.get( classLoader.getResource( filePath ).toURI() );
    }
}
