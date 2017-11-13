package com.brcities.file.parser;

import com.brcities.mappers.EntityMapper;

import java.io.BufferedReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvParser<T> implements FileParser<T> {
    private BufferedReader reader;
    private boolean skipHeader;
    private String separator = ",";
    private EntityMapper<T> mapper;

    public CsvParser(BufferedReader reader, EntityMapper mapper) {
        this.reader = reader;
        this.mapper = mapper;
    }

    @Override
    public List<T> parse() {
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

    public CsvParser separator(String separator){
        this.separator = separator;
        return this;
    }
}
