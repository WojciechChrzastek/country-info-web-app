package main.java.net.chrzastek.countryInfoWebApp.database;

import main.java.net.chrzastek.countryInfoWebApp.model.CountryNameData;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DbHandler {
  public Connection connectToNewDatabase(String databaseName) {
    Connection conn = null;
    try {
      String url = "jdbc:sqlite:" + databaseName;
      conn = DriverManager.getConnection(url);
      File file = new File("");
      System.out.println("New database '" + databaseName + "' has been created in: " + file.getAbsolutePath());
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
            + "	countryName TEXT"
            + ");";
    try (Statement stmt = conn.createStatement()) {
      stmt.execute(createTable);
      System.out.println("Table '" + tableName + "' has been created.");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public List<String> generateRandomIpNumbersList() {
    Random r = new Random();
    List<String> ipNumbers = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      String ip = r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256);
      ipNumbers.add(ip);
    }
    return ipNumbers;
  }

  public void insertIpNumbers(Connection conn, String tableName, List<String> ipNumbers) {
    for (String ip : ipNumbers) {
      String sql = "INSERT INTO ".concat(tableName).concat("(ip) VALUES(?);");
      try (PreparedStatement pstmt = conn.prepareStatement((sql))) {
        pstmt.setString(1, ip);
        pstmt.executeUpdate();
      } catch (SQLException e) {
        System.out.println(e.getMessage());
      }
    }
    System.out.println(ipNumbers.size() + " IP numbers have been inserted into '" + tableName + "' table.");
  }

  public void updateFromResponse(Connection conn, String tableName, String timestamp, String countryName, String ip) {
    if (countryName.equals("")) {
      countryName = "unknown";
    }
    String sql = "UPDATE " +
            tableName + " SET"
            + "	isProcessed = true, "
            + "	processedTimestamp = ? , "
            + "	countryName = ? "
            + "WHERE ip = ?;";
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setString(1, timestamp);
      pstmt.setString(2, countryName);
      pstmt.setString(3, ip);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public static List<String> selectInitialIp(Connection conn) {
    String sql = "SELECT ip " + "FROM " + "ipNumbers" + " WHERE id <= 100 ;";
    String ipNumber = "";
    List<String> listInitialIp = new ArrayList<>();
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        ipNumber = rs.getString("ip");
        listInitialIp.add(ipNumber);
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return listInitialIp;
  }

  public static List<String> selectNotProcessedIp(Connection conn) {
    String sql = "SELECT ip " + "FROM " + "ipNumbers" + " WHERE isProcessed = false;";
    String ipNumber = "";
    List<String> listIp = new ArrayList<>();
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        ipNumber = rs.getString("ip");
        listIp.add(ipNumber);
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return listIp;
  }

  public static void updateAllRows(Connection conn, DbHandler dbHandler) {
    System.out.println("Updating database based on API response...");
    List<String> listIp = selectNotProcessedIp(conn);
    for (String ip : listIp) {
      CountryNameData countryNameData = null;
      try {
        countryNameData = CountryNameData.getCountryNameDataFromIp(ip);
      } catch (IOException e) {
        e.printStackTrace();
      }
      String countryName = null;
      if (countryNameData != null) {
        countryName = countryNameData.getCountryName();
      }
      String timestamp = null;
      if (countryNameData != null) {
        timestamp = countryNameData.getTimestamp().toString();
      }
      if (countryName != null) {
        dbHandler.updateFromResponse(conn, "ipNumbers", timestamp, countryName, ip);
      }
    }
    System.out.println("Database has been updated.");
  }

}
