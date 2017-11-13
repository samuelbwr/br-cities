package com.brcities.datasource;

import com.brcities.file.parser.FileParser;

import java.util.List;

public interface DataSource<T> {
    void populateFromFile(String path, FileParser<T> parser);

    List<T> getData();
}
