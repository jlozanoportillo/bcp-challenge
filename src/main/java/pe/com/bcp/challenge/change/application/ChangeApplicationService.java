package pe.com.bcp.challenge.change.application;

import java.math.BigDecimal;
import java.util.Objects;

import org.springframework.stereotype.Service;

import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;
import pe.com.bcp.challenge.common.application.Notification;

@Slf4j
@Service
public class ChangeApplicationService {

  public Single<BigDecimal> getChange(String currencyLabelFrom,
      BigDecimal amount, String currencyLabelTo) {
    log.info("Into getChange()");
    return Single.fromCallable(() -> { 
      Notification notification = this.changeValidate(currencyLabelFrom, amount,
          currencyLabelTo);
      if(notification.hasErrors()) {
        throw new IllegalArgumentException(notification.errorMessage());
      }
      return null;
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

    return notification;
  }

}
