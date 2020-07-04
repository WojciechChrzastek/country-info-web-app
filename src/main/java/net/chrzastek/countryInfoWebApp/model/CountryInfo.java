package main.java.net.chrzastek.countryInfoWebApp.model;

import main.java.net.chrzastek.countryInfoWebApp.database.DbHandler;

import java.sql.Connection;

public class CountryInfo {
  private static final String DB_NAME = "country-info.db";
  private static final String TABLE_NAME = "ipNumbers";

  public static void main(String[] args) {
    DbHandler dbHandler = new DbHandler();
    Connection conn = dbHandler.connectToNewDatabase(DB_NAME);
    dbHandler.createNewTable(TABLE_NAME, conn);
  }
}
