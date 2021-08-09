package com.clustered.data.warehouse.warehouse.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "deals_details")
@Entity
@DynamicInsert
@DynamicUpdate
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DealsDetails {

	@Id
	private String id;
	
	private String fromCurrencyISOCode;
	
	private String toCurrencyISOCode; 
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@CreationTimestamp
	private LocalDateTime dealTimestamp;
	
	private BigDecimal dealAmountInOrderingCurrency;

}
