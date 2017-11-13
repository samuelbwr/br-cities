package com.brcities.file.parser;

import java.util.List;

public interface FileParser<T> {

    List<T> parse();

}
