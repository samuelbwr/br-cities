package com.brcities;

import com.brcities.city.CityDao;
import com.brcities.expression.parser.ExpressionParser;
import com.brcities.expression.result.Result;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class App {

    static final String CITIES_FILE = "cidades.csv";
    static final String EXIT_CODE = "exit";

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        CityDao cityDao = CityDao.getInstance();
        cityDao.populateFromResourceFile( CITIES_FILE );
        Scanner scanner = new Scanner( System.in );
        String command;
        Result result;
        do {
            System.out.println( "Enter a command or exit with '"+EXIT_CODE+"'" );
            command = scanner.nextLine();
            if (!EXIT_CODE.equals( command )) {
                result = ExpressionParser.getInstance().parse( command ).interpret( cityDao.getData() );
                System.out.println( result );
            }
        } while (!EXIT_CODE.equals( command ));
    }
}
