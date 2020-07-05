//package test.java.net.chrzastek.countryInfoWebApp.dao;
//
//import main.java.net.chrzastek.countryInfoWebApp.dao.CountryInfoDao;
//import main.java.net.chrzastek.countryInfoWebApp.dao.CountryInfoDaoImpl;
//import main.java.net.chrzastek.countryInfoWebApp.model.CountryInfo;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class CountryInfoDaoTest {
//  private DriverManagerDataSource dataSource;
//  private CountryInfoDao dao;
//
//  @BeforeEach
//  void setupBeforeEach() {
//    dataSource = new DriverManagerDataSource();
//    dataSource.setDriverClassName("org.sqlite.JDBC");
//    dataSource.setUrl("jdbc:sqlite:country-info.db");
//
//    dao = new CountryInfoDaoImpl(dataSource);
//  }
//
//  @Test
//  void testShowGeneratedIpNumbers() {
//    List<String> ipNumbers = dao.showGeneratedIpNumbers();
//    for (String ipNumber : ipNumbers) {
//      System.out.println(ipNumber);
//    }
//    assertEquals(3, ipNumbers.size());
//  }
//
//  @Test
//  void testAddIpNumber() {
//    CountryInfo countryInfo = new CountryInfo("180.10.15.20");
//    int result = dao.addIpNumber(countryInfo);
//
//    assertTrue(result > 0);
//  }
//
//  @Test
//  void showReport() {
//    List<CountryInfo> countryInfoList = dao.showReport();
//    for (CountryInfo countryInfo : countryInfoList) {
//      System.out.println(countryInfo);
//    }
//    assertFalse(countryInfoList.isEmpty());
//  }
//
//}
