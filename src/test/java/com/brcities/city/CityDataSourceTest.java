package com.brcities.city;

import com.brcities.datasource.DataSource;
import com.brcities.file.parser.CsvParser;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CityDataSourceTest {

    @Test
    public void ensureCanPopulateDataSource() throws URISyntaxException, FileNotFoundException {
        DataSource dataSource = CityDataSource.getInstance();
        dataSource.populateFromFile( CityStub.getCitiesFilePath(),
                new CsvParser( CityMapper.getInstance() ).skippingHeader() );
        assertThat( dataSource.getData().size(), equalTo( 3 ) );
    }
}
