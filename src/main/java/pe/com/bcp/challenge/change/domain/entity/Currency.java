package pe.com.bcp.challenge.change.domain.entity;

import java.math.BigDecimal;

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

}
