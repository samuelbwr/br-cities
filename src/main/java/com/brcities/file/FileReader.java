package com.brcities.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {

    private Path path;

    public FileReader(Path path) {
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
