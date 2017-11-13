package com.brcities;

import com.brcities.city.City;
import com.brcities.city.CityMapper;
import com.brcities.expression.parser.ExpressionParser;
import com.brcities.expression.result.Result;
import com.brcities.file.File;
import com.brcities.file.FileReader;
import com.brcities.file.parser.CsvParser;
import com.brcities.file.parser.FileParser;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader reader = new FileReader( File.fromResource( "cidades.csv" ) );
        FileParser parser = new CsvParser( reader.read(), CityMapper.getInstance() ).skippingHeader();
        List<City> cities = parser.parse();
        Scanner scanner = new Scanner( System.in );
        String command;
        ExpressionParser expressionParser = ExpressionParser.getInstance();
        Result result;
        do {
            System.out.println( "Enter a command or exit with 'exit'" );
            command = scanner.nextLine();
            if (!"exit".equals( command )) {
                result = expressionParser.parse( command ).interpret( cities );
                System.out.println(result);
            }
        } while (!"exit".equals( command ));
    }
}
