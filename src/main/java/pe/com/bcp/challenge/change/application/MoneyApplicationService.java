package pe.com.bcp.challenge.change.application;

import java.math.BigDecimal;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;
import pe.com.bcp.challenge.change.application.dto.CurrencyDto;
import pe.com.bcp.challenge.change.domain.entity.Currency;
import pe.com.bcp.challenge.change.domain.repository.CurrencyRepository;
import pe.com.bcp.challenge.common.application.Notification;

@Slf4j
@Service
public class MoneyApplicationService {

  @Autowired
  private CurrencyRepository currencyRepository;

  public Single<Integer> create(CurrencyDto currencyDto) throws Exception {
    log.info("Into create"); 
    return Single.fromCallable(() -> {
      Notification notification = this.createValidation(currencyDto);
      if (notification.hasErrors()) {
        throw new IllegalArgumentException(notification.errorMessage());
      }
      Currency currency = new Currency();
      currency.setLabel(currencyDto.getLabel());
      currency.setChageAmount(currencyDto.getAmountChange());
      return currencyRepository.save(currency); 
    });
  }

  private Notification createValidation(CurrencyDto currencyDto) {
    Notification notification = new Notification();

    if (Objects.isNull(currencyDto.getLabel())
        || currencyDto.getLabel().length() >= 5) {
      notification.addError("Label field malformed");
    }

    if (Objects.isNull(currencyDto.getAmountChange())
        || currencyDto.getAmountChange().compareTo(new BigDecimal(0)) <= 0) {
      notification.addError("El monto no puede ser 0 o negativo");
    }
    Currency currency = currencyRepository.findByLabel(currencyDto.getLabel());
    if (Objects.nonNull(currency)) {
      notification.addError("Currency already registered");
    }

    return notification;
  }

}
