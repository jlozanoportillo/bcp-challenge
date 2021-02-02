package pe.com.bcp.challenge.change.application;

import java.math.BigDecimal;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;
import pe.com.bcp.challenge.change.domain.entity.Currency;
import pe.com.bcp.challenge.change.domain.repository.CurrencyRepository;
import pe.com.bcp.challenge.common.application.Notification;

@Slf4j
@Service
public class ChangeApplicationService {
  
  @Autowired
  private CurrencyRepository currencyRepository;
  
  private Currency currencyFrom;
  
  private Currency currencyTo;
  
  public Single<BigDecimal> getChange(String currencyLabelFrom,
      BigDecimal amount, String currencyLabelTo) {
    log.info("Into getChange()");
    return Single.fromCallable(() -> {
      Notification notification = this.changeValidate(currencyLabelFrom, amount,
          currencyLabelTo);
      if(notification.hasErrors()) {
        throw new IllegalArgumentException(notification.errorMessage());
      }
      
      return currencyFrom.changeAmount(currencyTo, amount);
      
    });

  }

  private Notification changeValidate(String currencyLabelFrom,
      BigDecimal amount, String currencyLabelTo) {
    Notification notification = new Notification();
    if (Objects.isNull(currencyLabelFrom) || currencyLabelFrom.length() > 5) {
      notification
          .addError("Label \ncurrency from\" is not defined or bad formed");
    }
    if (Objects.isNull(currencyLabelTo)) {
      notification.addError("Label \ncurrency to\" is not defined");
    }
    if (Objects.isNull(amount)) {
      notification.addError("Label \n amount \" is not defined");
    }
    currencyFrom  = currencyRepository.findByLabel(currencyLabelFrom);
    if(Objects.isNull(currencyFrom)) {
      notification.addError("Currency origin not supported");
    }
    currencyTo  = currencyRepository.findByLabel(currencyLabelTo);
    if(Objects.isNull(currencyTo)) {
      notification.addError("Currency destiny not supported");
    }

    return notification;
  }

}
