package com.clustered.data.warehouse.warehouse.payload;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DealDetailsDTO {

	private String id;
	
	@NotEmpty(message = "From currency ISO code is required!")
	@Size(max = 3, min = 3, message = "Should be min 3 charachters")
	private String fromCurrencyISOCode;
	
	@NotEmpty(message = "To currency ISO code is required!")
	private String toCurrencyISOCode; 
	
	@NotNull(message = "Deal amount in ordering currency is required!")
	private BigDecimal dealAmountInOrderingCurrency;
	
}
