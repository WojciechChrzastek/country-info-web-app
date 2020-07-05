package main.java.net.chrzastek.countryInfoWebApp.dao;

import main.java.net.chrzastek.countryInfoWebApp.model.CountryInfo;

import java.util.List;

public interface CountryInfoDao {

  List<String> showGeneratedIpNumbers();

  int addIpNumber(CountryInfo countryInfo);

  List<CountryInfo> showReport();

}
