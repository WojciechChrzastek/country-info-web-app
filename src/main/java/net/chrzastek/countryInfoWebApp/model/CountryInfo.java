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
}
