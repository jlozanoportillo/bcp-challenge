package pe.com.bcp.challenge.change.application;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChangeApplicationService {

  public Single<BigDecimal> getChange(String currencyLabelFrom,
      BigDecimal amount, String currencyLabelTo) {
    log.info("Into getChange()");
    
    
    
    return null;
  }

}
