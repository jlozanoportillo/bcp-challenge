package pe.com.bcp.challenge.change.application.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateRequest {
  
  private String label;
  
  private BigDecimal newAmount;
  
}
