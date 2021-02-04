package pe.com.bcp.challenge.change.application.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateRequest {
  
  
  private BigDecimal newAmount;
  
}
