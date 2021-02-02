package pe.com.bcp.challenge.change.infrastructure.jdbc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.com.bcp.challenge.change.domain.entity.Currency;

public class CurrencyMapper implements RowMapper<Currency> {

  @Override
  public Currency mapRow(ResultSet rs, int rowNum)
      throws SQLException {
    Currency currency = new Currency();
    currency.setId(rs.getInt("id"));
    currency.setLabel(rs.getString("label"));
    currency.setChageAmount(rs.getBigDecimal("changeamount"));
    return currency;
  }

}
