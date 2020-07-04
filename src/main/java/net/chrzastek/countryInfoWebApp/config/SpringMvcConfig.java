package main.java.net.chrzastek.countryInfoWebApp.config;

import main.java.net.chrzastek.countryInfoWebApp.dao.CountryInfoDao;
import main.java.net.chrzastek.countryInfoWebApp.dao.CountryInfoDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "main.java.net.chrzastek.countryInfoWebApp")
public class SpringMvcConfig implements WebMvcConfigurer {

  @Bean
  public DataSource getDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.sqlite.JDBC");
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
