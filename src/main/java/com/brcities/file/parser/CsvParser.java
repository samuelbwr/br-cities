package com.brcities.file.parser;

import com.brcities.file.FileReader;
import com.brcities.mappers.EntityMapper;

import java.io.BufferedReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvParser<T> implements FileParser<T> {
    private boolean skipHeader;
    private String separator = ",";
    private final EntityMapper<T> mapper;

    public CsvParser(final EntityMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<T> parse(BufferedReader reader) {
        Stream<String> lines = reader.lines();
        if (skipHeader)
            lines = lines.skip( 1 );
        Stream<String[]> splittedLines = lines.map( s -> s.split( separator ) );
        return splittedLines.map( s -> mapper.fromOrderedStringArray( s ) ).collect( Collectors.toList() );
    }

    public CsvParser skippingHeader(){
        this.skipHeader = true;
        return this;
    }

    public CsvParser separator(final String separator){
        this.separator = separator;
        return this;
    }
}
