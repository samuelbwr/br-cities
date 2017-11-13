package com.brcities.file;

public class FileNotReadableException extends RuntimeException {

    public FileNotReadableException(String message, Throwable cause) {
        super( message, cause );
    }
}
