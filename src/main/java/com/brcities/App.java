package com.brcities;

import com.brcities.city.CityDataSource;
import com.brcities.city.CityMapper;
import com.brcities.city.CityService;
import com.brcities.datasource.DataSource;
import com.brcities.file.parser.CsvParser;
import com.brcities.file.parser.FileParser;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class App {

    private static final String CITIES_FILE = "/cidades.csv";
    private static final String EXIT_CODE = "exit";

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        App app = new App();
        final CityService cityService = new CityService( app.createDataSource() );
        final Scanner scanner = new Scanner( System.in );
        String command;
        do {
            System.out.println( "Enter a command or exit with '" + EXIT_CODE + "'" );
            command = scanner.nextLine();
            if (!app.isExitCode( command ))
                System.out.println( cityService.runCommand( command ) );
        } while (!app.isExitCode( command ));
    }

    private DataSource createDataSource() throws FileNotFoundException, URISyntaxException {
        final DataSource dataSource = CityDataSource.getInstance();
        final FileParser fileParser = new CsvParser( CityMapper.getInstance() ).skippingHeader();
        dataSource.populateFromFile( CITIES_FILE, fileParser );
        return dataSource;
    }

    private boolean isExitCode(final String command) {
        return EXIT_CODE.equals( command );
    }

}
