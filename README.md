# Brazilian Cities ![Codacy Badge](https://api.codacy.com/project/badge/Grade/982ae1b3088742c992cb9c54c616a040)

Simple project to query for brazilian cities coming from a CSV file (located on Resoures).

To run:
```
mvn clean install
java -jar target/br-query-1.0-jar-with-dependencies.jar 
```

To interact with you can use the following commands:
```
count *
count distinct [property]
filter [property] [value]
```

The possible properties are

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


Code developed only with:
 - Java 8
 - Maven
 - JUnit