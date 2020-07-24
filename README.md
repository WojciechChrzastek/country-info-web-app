# Country-info WebApp

## About the project

Simple web application that communicates with a free, open source [API "ip2country"](https://ip2country.info/) to get the country name based on a given IP. The database used for the project runs on [SQLite](https://www.sqlite.org/index.html), so there is no need for any database configuration.

### Running the application
You can easily run this app on an [Apache Tomcat](http://tomcat.apache.org/) server using the attached [.war file](https://github.com/WojciechChrzastek/country-info-web-app/blob/master/target/country-info-web-app-1.0-SNAPSHOT.war?raw=true).

After the startup, the app will execute the following procedures:

1. Creating a database in the bin folder of your Tomcat server.
2. Establishing the connection to the database.
3. Creating an empty table in the database.
4. Generating 100 random IP numbers and putting them in a created table.

Then the application homepage will be displayed in your OS default web browser.

### Using the application
There are following actions to choose from:
1. Show initial IP addresses generated on application startup.
2. Manually Add IP to the database by filling a simple form.
3. Update all rows which have not yet a country name assigned to given ip number.
4. Show report - current database content.

### Main topics covered by this project
- Spring basics
- servlets
- working with .jsp
- SQL and JDBC
- Maven

After the app shutdown you should manually delete the database created by the app in your Tomcat server bin folder.

The project is created in [Java 1.8.0_202](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html) and uses [SQLite 3.32.3](https://www.sqlite.org/releaselog/3_32_3.html). Tested to run under [Apache Tomcat 8.5.56](https://tomcat.apache.org/download-80.cgi).