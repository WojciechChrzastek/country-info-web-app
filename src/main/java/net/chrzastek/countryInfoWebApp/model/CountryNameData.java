package main.java.net.chrzastek.countryInfoWebApp.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Timestamp;

public class CountryNameData {

  private static final String API_URL = "https://api.ip2country.info/ip?";

  @SerializedName("countryCode")
  private String countryCodeIsoAlpha2;

  @SerializedName("countryCode3")
  private String countryCodeIsoAlpha3;

  @SerializedName("countryName")
  private String countryName;

  @SerializedName("countryEmoji")
  private String countryEmoji;

  private Timestamp timestamp;

  public Timestamp getTimestamp() {
    return new Timestamp(System.currentTimeMillis());
  }

  public String getCountryCodeIsoAlpha2() {
    return countryCodeIsoAlpha2;
  }

  public String getCountryCodeIsoAlpha3() {
    return countryCodeIsoAlpha3;
  }

  public String getCountryName() {
    return countryName;
  }

  public String getCountryEmoji() {
    return countryEmoji;
  }

  public static CountryNameData getCountryNameDataFromIp(String ip) throws IOException {
    URL url = new URL(API_URL + ip);
    InputStreamReader reader = new InputStreamReader(url.openStream());
    return new Gson().fromJson(reader, CountryNameData.class);
  }

  @Override
  public String toString() {
    return "CountryNameData{" +
            "countryCodeIsoAlpha2='" + countryCodeIsoAlpha2 + '\'' +
            ", countryCodeIsoAlpha3='" + countryCodeIsoAlpha3 + '\'' +
            ", countryName='" + countryName + '\'' +
            ", countryEmoji='" + countryEmoji + '\'' +
            '}';
  }
}
