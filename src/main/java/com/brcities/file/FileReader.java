package com.brcities.file;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FileReader {

    private final String path;

    public FileReader(final String path) {
        this.path = path;
    }

    public BufferedReader read() {
        try {
            return new BufferedReader( new InputStreamReader( this.getClass().getResourceAsStream( path ) ) );
        } catch (Exception e) {
            throw new FileNotReadableException( "Unable to read the file", e );
        }
    }
}
