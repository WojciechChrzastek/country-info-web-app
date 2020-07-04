package main.java.net.chrzastek.countryInfoWebApp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbHandler {
  public Connection connectToNewDatabase(String databaseName) {
    Connection conn = null;
    try {
      String url = "jdbc:sqlite:" + databaseName;
      conn = DriverManager.getConnection(url);
      System.out.println("Connection to " + databaseName + " database has been established.");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return conn;
  }

  public void createNewTable(String tableName, Connection conn) {
    String createTable = "CREATE TABLE IF NOT EXISTS " +
            tableName +
            "(id INTEGER PRIMARY KEY,"
            + "	isProcessed BOOLEAN DEFAULT false,"
            + "	processedTimestamp TEXT,"
            + "	ip TEXT,"
            + "	countryName TEXT DEFAULT ('unknown')"
            + ");";
    try (Statement stmt = conn.createStatement()) {
      stmt.execute(createTable);
      System.out.println("Table '" + tableName + "' has been created.");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}
