package pe.com.bcp.challenge.change.domain.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Currency {

  private Integer id;

  private String label;

  private BigDecimal chageAmount;

  public BigDecimal changeAmount(Currency currencyDestiny, BigDecimal amount) {
    BigDecimal amountChange = (this.chageAmount.divide(currencyDestiny.getChageAmount(), RoundingMode.HALF_UP) );
    return amountChange.multiply(amount);
  }
}
