# Brazilian Cities

Simple project to query for brazilian cities coming from a CSV file (on Resoures folder).

To run:
```
mvn clean install
java -jar target/brCities-1.0-SNAPSHOT-jar-with-dependencies.jar 
```

To interact you can use the following commands:
```
count *
count distinct [property]
filter [property] [value]
```

The available properties are

 - ibge_id
 - uf
 - name
 - capital
 - lon 
 - lat
 - no_accents
 - alternative_names 
 - microregion
 - mesoregion


Code developed with:
 - Java 8
 - Maven
 - JUnit