package com.brcities.file;

import com.brcities.city.City;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class FileParserTest {

    @Test
    public void ensureCanParse() {
        String csvRow = "1,SC,Full City,false,-4.32,5.21,Full City,Full City name,MicroRegion,MesoRegion";
        FileParser fileParser = new CsvFileParser( new CityMapper(), false );
        City city = fileParser.parse( csvRow );
        assertNotNull( city );
    }

    @Test(expected = FileParseException.class)
    public void ensureCanParse() {
        String csvRow = "1SC,Full City,false,-4.32,5.21,Full City,Full City name,MicroRegion,MesoRegion";
        FileParser fileParser = new CsvFileParser( new CityMapper(), false );
        fileParser.parse( csvRow );
    }

}
