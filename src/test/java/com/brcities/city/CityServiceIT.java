package com.brcities.city;

import com.brcities.city.model.City;
import com.brcities.expression.parser.ParseException;
import com.brcities.expression.result.ListResult;
import com.brcities.expression.result.LongResult;
import org.junit.Test;

import java.net.URISyntaxException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CityServiceIT {

    @Test
    public void ensureCanExecuteCountAllCommand() throws URISyntaxException {
        CityService cityService = new CityService( CityStub.createDefaultDataSource() );
        LongResult result = (LongResult) cityService.runCommand( "count *" );
        assertThat( result.getValue(), equalTo( 3l ) );
    }

    @Test
    public void ensureCanExecuteCountDistinctCommand() throws URISyntaxException {
        CityService cityService = new CityService( CityStub.createDefaultDataSource() );
        LongResult result = (LongResult) cityService.runCommand( "count distinct uf" );
        assertThat( result.getValue(), equalTo( 1l ) );
    }

    @Test
    public void ensureCanExecuteFilterCommand() throws URISyntaxException {
        String cityName = "Ariquemes";
        CityService cityService = new CityService( CityStub.createDefaultDataSource() );
        ListResult<City> result = (ListResult) cityService.runCommand( "filter name "+cityName );
        assertThat( result.getValue().size(), equalTo( 1 ) );
        assertThat( result.getValue().get(0).getName(), equalTo( cityName ) );
    }

    @Test(expected = ParseException.class)
    public void ensureCantExecuteUnknownCommand() throws URISyntaxException {
        CityService cityService = new CityService( CityStub.createDefaultDataSource() );
        cityService.runCommand( "add other name" );
    }
}
