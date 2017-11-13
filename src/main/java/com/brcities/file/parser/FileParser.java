package com.brcities.file.parser;

import java.io.BufferedReader;
import java.util.List;

public interface FileParser<T> {

    List<T> parse(BufferedReader reader);

}
