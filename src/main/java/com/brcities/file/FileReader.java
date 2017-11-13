package com.brcities.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {

    private final Path path;

    public FileReader(final Path path) {
        this.path = path;
    }

    public BufferedReader read() throws FileNotFoundException {
        try {
            return Files.newBufferedReader( path );
        } catch (Exception e) {
            throw new FileNotFoundException();
        }
    }
}
