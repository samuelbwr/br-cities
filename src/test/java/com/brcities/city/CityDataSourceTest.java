package com.brcities.city;

import com.brcities.dataSource.DataSource;
import com.brcities.file.FileReaderTest;
import com.brcities.file.parser.CsvParser;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

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
