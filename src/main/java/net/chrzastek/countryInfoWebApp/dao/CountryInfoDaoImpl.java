package main.java.net.chrzastek.countryInfoWebApp.dao;

import main.java.net.chrzastek.countryInfoWebApp.model.CountryInfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CountryInfoDaoImpl implements CountryInfoDao {

  private JdbcTemplate jdbcTemplate;

  public CountryInfoDaoImpl(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public List<String> showGeneratedIpNumbers() {
    String sql = "SELECT ip FROM ipNumbers";

    RowMapper<String> rowMapper = new RowMapper<String>() {

      @Override
      public String mapRow(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getString("ip");
      }
    };
    return jdbcTemplate.query(sql, rowMapper);

  }

  @Override
  public int addIpNumber(CountryInfo countryInfo) {
    String sql = "INSERT INTO ipNumbers (ip) VALUES (?)";
    return jdbcTemplate.update(sql, countryInfo.getIp());
  }

  @Override
  public List<CountryInfo> showReport() {
    String sql = "SELECT * FROM ipNumbers";

    RowMapper<CountryInfo> rowMapper = new RowMapper<CountryInfo>() {

      @Override
      public CountryInfo mapRow(ResultSet resultSet, int i) throws SQLException {
        Integer id = resultSet.getInt("id");
        Boolean isProcessed = resultSet.getBoolean("isProcessed");
        String processedTimestamp = resultSet.getString("processedTimestamp");
        String ip = resultSet.getString("ip");
        String countryName = resultSet.getString("countryName");

        return new CountryInfo(id, isProcessed, processedTimestamp, ip, countryName);
      }
    };
    return jdbcTemplate.query(sql, rowMapper);
  }

}
