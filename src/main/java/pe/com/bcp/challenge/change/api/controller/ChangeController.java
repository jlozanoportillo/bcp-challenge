package pe.com.bcp.challenge.change.api.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;
import pe.com.bcp.challenge.change.application.MoneyApplicationService;
import pe.com.bcp.challenge.common.api.controller.ResponseHandler;

@Slf4j
@RestController
@RequestMapping(value = "/api/change")
public class ChangeController {

  @Autowired
  private ResponseHandler responseHandler;
  
  @Autowired
  private MoneyApplicationService moneyApplicationService;

  @GetMapping(value = "/{currencyLabelFrom}/{amount}/{currencyLabelTo}")
  public Single<ResponseEntity<Object>> getChange(
      @PathVariable("currencyLabelFrom")String currencyLabelFrom,
      @PathVariable("amount") BigDecimal amount,
      @PathVariable("currencyLabelTo") String currencyLabelTo) {
    log.info("Into getChange()");
    
    
    return null;
  }

}
