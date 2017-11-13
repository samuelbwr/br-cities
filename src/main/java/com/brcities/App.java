package com.brcities;

import com.brcities.city.CityDataSource;
import com.brcities.city.CityMapper;
import com.brcities.expression.parser.ExpressionParser;
import com.brcities.expression.result.Result;
import com.brcities.file.parser.CsvParser;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class App {

    private static final String CITIES_FILE = "cidades.csv";
    private static final String EXIT_CODE = "exit";

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        final CityDataSource cityDataSource = createDataSource();
        final Scanner scanner = new Scanner( System.in );
        String command;
        Result result;
        do {
            System.out.println( "Enter a command or exit with '" + EXIT_CODE + "'" );
            command = scanner.nextLine();
            if (!isExitCode( command )) {
                result = ExpressionParser.getInstance().parse( command ).interpret( cityDataSource.getData() );
                System.out.println( result );
            }
        } while (!isExitCode( command ));
    }

    private static CityDataSource createDataSource() throws FileNotFoundException, URISyntaxException {
        final CityDataSource cityDataSource = CityDataSource.getInstance();
        cityDataSource.populateFromResourcesFile( CITIES_FILE, new CsvParser( CityMapper.getInstance() ).skippingHeader() );
        return cityDataSource;
    }

    private static boolean isExitCode(final String command) {
        return EXIT_CODE.equals( command );
    }
}
