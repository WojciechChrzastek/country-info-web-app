package main.java.net.chrzastek.countryInfoWebApp.model;

import main.java.net.chrzastek.countryInfoWebApp.database.DbHandler;

import java.sql.Connection;

public class CountryInfo {
  private static final String DB_NAME = "country-info.db";
  private static final String TABLE_NAME = "ipNumbers";

  private Integer id;
  private Boolean isProcessed;
  private String processedTimestamp;
  private String ip;
  private String countryName;

  public static void main(String[] args) {
    DbHandler dbHandler = new DbHandler();
    Connection conn = dbHandler.connectToNewDatabase(DB_NAME);
    dbHandler.createNewTable(TABLE_NAME, conn);
  }

  public CountryInfo(Integer id, Boolean isProcessed, String processedTimestamp, String ip, String countryName) {
    this.id = id;
    this.isProcessed = isProcessed;
    this.processedTimestamp = processedTimestamp;
    this.ip = ip;
    this.countryName = countryName;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Boolean getProcessed() {
    return isProcessed;
  }

  public void setProcessed(Boolean processed) {
    isProcessed = processed;
  }

  public String getProcessedTimestamp() {
    return processedTimestamp;
  }

  public void setProcessedTimestamp(String processedTimestamp) {
    this.processedTimestamp = processedTimestamp;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public String getCountryName() {
    return countryName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }
}
