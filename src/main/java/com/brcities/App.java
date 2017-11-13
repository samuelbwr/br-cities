package com.brcities;

import com.brcities.city.CityDataSource;
import com.brcities.city.CityMapper;
import com.brcities.city.CityService;
import com.brcities.city.model.City;
import com.brcities.datasource.DataSource;
import com.brcities.file.parser.CsvParser;
import com.brcities.file.parser.FileParser;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {

    private static final String CITIES_FILE = "cidades.csv";
    private static final String EXIT_CODE = "exit";

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        final CityService cityService = new CityService( createDataSource() );
        final Scanner scanner = new Scanner( System.in );
        String command;
        do {
            System.out.println( "Enter a command or exit with '" + EXIT_CODE + "'" );
            command = scanner.nextLine();
            if (!isExitCode( command ))
                System.out.println( cityService.runCommand( command ) );
        } while (!isExitCode( command ));
    }

    private static DataSource createDataSource() throws FileNotFoundException, URISyntaxException {
        final DataSource dataSource = CityDataSource.getInstance();
        final FileParser fileParser = new CsvParser( CityMapper.getInstance() ).skippingHeader();
        dataSource.populateFromFile( getFilePath( CITIES_FILE ), fileParser );
        return dataSource;
    }

    private static boolean isExitCode(final String command) {
        return EXIT_CODE.equals( command );
    }

    private static Path getFilePath(final String filePath) throws URISyntaxException {
        final ClassLoader classLoader = City.class.getClassLoader();
        return Paths.get( classLoader.getResource( filePath ).toURI() );
    }
}
