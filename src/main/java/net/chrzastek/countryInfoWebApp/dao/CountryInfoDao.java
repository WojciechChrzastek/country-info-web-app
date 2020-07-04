package main.java.net.chrzastek.countryInfoWebApp.dao;

import main.java.net.chrzastek.countryInfoWebApp.model.CountryInfo;

import java.util.List;

public interface CountryInfoDao {

  public List<String> showGeneratedIpNumbers();

  public String addIpNumber(CountryInfo countryInfo);

  public List<CountryInfo> showReport();
}
