package pe.com.bcp.challenge.change.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;
import pe.com.bcp.challenge.change.application.MoneyApplicationService;
import pe.com.bcp.challenge.change.application.dto.CurrencyDto;
import pe.com.bcp.challenge.common.api.controller.ResponseHandler;

@Slf4j
@RestController
@RequestMapping(value = "/api/currency")
public class MoneyController {

  @Autowired
  private ResponseHandler responseHandler;

  @Autowired
  private MoneyApplicationService moneyApplicationService;

  @GetMapping(value = "/health")
  public String healthy() {
    return "Hello Mama";
  }

  @SuppressWarnings("deprecation")
  @PostMapping(
      value = "/add", 
      consumes = MediaType.APPLICATION_JSON_VALUE, 
      produces = {
          MediaType.APPLICATION_STREAM_JSON_VALUE,
          MediaType.APPLICATION_JSON_VALUE}
      )
  public Single<ResponseEntity<Object>> createCurrency(
      @RequestBody CurrencyDto currencyDto) throws Exception {
    log.info("Into createCurrency()");

    return moneyApplicationService.create(currencyDto)
        .map(res -> responseHandler.getResponse(res, HttpStatus.OK) )
        .onErrorReturn(r->   responseHandler.getAppCustomErrorResponse(r.getMessage() ) )
        .subscribeOn(Schedulers.io());
         
  }

}
