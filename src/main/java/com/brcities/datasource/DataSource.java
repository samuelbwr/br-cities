package com.brcities.datasource;

import com.brcities.file.parser.FileParser;

import java.nio.file.Path;
import java.util.List;

public interface DataSource<T> {
    void populateFromFile(Path path, FileParser<T> parser);

    List<T> getData();
}
