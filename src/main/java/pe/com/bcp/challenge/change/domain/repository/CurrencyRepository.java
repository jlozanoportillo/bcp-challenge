package pe.com.bcp.challenge.change.domain.repository;

import java.util.List;

import pe.com.bcp.challenge.change.domain.entity.Currency;

public interface CurrencyRepository {
  
  int count();
  
  int save(Currency currency);
  
  int update(Currency currency);
  
  int deleteByID(Integer id);
  
  List<Currency> findAll();

  Currency findByLabel(String label);
   

}
