package main.java.net.chrzastek.countryInfoWebApp.model;

public class CountryInfo {

  private Integer id;
  private Boolean isProcessed;
  private String processedTimestamp;
  private String ip;
  private String countryName;

  public CountryInfo(Integer id, Boolean isProcessed, String processedTimestamp, String ip, String countryName) {
    this.id = id;
    this.isProcessed = isProcessed;
    this.processedTimestamp = processedTimestamp;
    this.ip = ip;
    this.countryName = countryName;
  }

  public CountryInfo() {
  }

  public CountryInfo(String ip) {
    this.ip = ip;
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

  public void setProcessed(Boolean isProcessed) {
    this.isProcessed = isProcessed;
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

  @Override
  public String toString() {
    return "CountryInfo{" +
            "id=" + id +
            ", isProcessed=" + isProcessed +
            ", processedTimestamp='" + processedTimestamp + '\'' +
            ", ip='" + ip + '\'' +
            ", countryName='" + countryName + '\'' +
            '}';
  }
}
