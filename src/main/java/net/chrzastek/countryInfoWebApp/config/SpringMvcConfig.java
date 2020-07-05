package main.java.net.chrzastek.countryInfoWebApp.config;

import main.java.net.chrzastek.countryInfoWebApp.dao.CountryInfoDao;
import main.java.net.chrzastek.countryInfoWebApp.dao.CountryInfoDaoImpl;
import main.java.net.chrzastek.countryInfoWebApp.database.DbHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "main.java.net.chrzastek.countryInfoWebApp")
public class SpringMvcConfig implements WebMvcConfigurer {

  public void createAndConnectToDbWithTable() {
    final String DB_NAME = "country-info.db";
    final DbHandler dbHandler = new DbHandler();
    final String TABLE_NAME = "ipNumbers";
    Connection conn = dbHandler.connectToNewDatabase(DB_NAME);
    dbHandler.createNewTable(TABLE_NAME, conn);
    final List<String> IP_NUMBERS_LIST = dbHandler.generateRandomIpNumbersList();
    dbHandler.insertIpNumbers(conn, TABLE_NAME, IP_NUMBERS_LIST);
  }

  @Bean
  public DataSource getDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.sqlite.JDBC");
    createAndConnectToDbWithTable();
    dataSource.setUrl("jdbc:sqlite:country-info.db");

    return dataSource;
  }

  @Bean
  public ViewResolver getViewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");

    return resolver;
  }

  @Bean
  public CountryInfoDao getCountryInfoDao() {
    return new CountryInfoDaoImpl(getDataSource());
  }

}
