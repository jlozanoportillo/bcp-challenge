package pe.com.bcp.challenge.change.infrastructure.jdbc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import pe.com.bcp.challenge.change.domain.entity.Currency;
import pe.com.bcp.challenge.change.domain.repository.CurrencyRepository;

@Slf4j
@Repository
public class CurrencyJdbcRepository implements CurrencyRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public int count() {
    log.info("Into count");
    String sql = "select count(*) from currency";
    return jdbcTemplate.queryForObject(sql, Integer.class);
  }

  @Override
  public int save(Currency currency) {
    log.info("Into save(Currency currency)");
    String sql = "insert into currency( label,changeamount) values(?,?)";
    return jdbcTemplate.update(sql, currency.getLabel(),
        currency.getChageAmount());
  }

  @Override
  public int update(Currency currency) {
    log.info("Into update(Currency currency)");
    String sql = "update currency set changeamount = ? where label = ?";
    return jdbcTemplate.update(sql, currency.getChageAmount(),
        currency.getLabel());
  }

  @Override
  public int deleteByID(Integer id) {
    log.info("Into deleteByID(Integer id)");
    String sql = "delete currency where id = ?";
    return jdbcTemplate.update(sql, id);
  }

  @Override
  public List<Currency> findAll() {
    log.info("Into findAll()");
    String sql = "select * from currency";
    return jdbcTemplate.query(sql, new CurrencyMapper());
  }

  @Override
  public Currency findByLabel(String label) {
    log.info("Into findByLabel(String label)");
    String sql = "select * from currency where label = ? ";
//    Currency currencyDb = jdbcTemplate.queryForObject(sql,
//        new CurrencyMapper(), 
//        new Object[] { label });
    
     @SuppressWarnings("deprecation")
    Currency sasasa = jdbcTemplate.queryForObject(sql, new Object[]{label}, new CurrencyMapper());
     return sasasa;
  }

}
