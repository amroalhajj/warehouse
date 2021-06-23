package com.clustered.data.warehouse.warehouse.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "deal_details")
@Entity
@DynamicInsert
@DynamicUpdate
public class DealDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String fromCurrencyISOCode;
	private String toCurrencyISOCode; 
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@CreationTimestamp
	private LocalDateTime dealTimestamp;
	
	private BigDecimal dealAmountInOrderingCurrency;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFromCurrencyISOCode() {
		return fromCurrencyISOCode;
	}

	public void setFromCurrencyISOCode(String fromCurrencyISOCode) {
		this.fromCurrencyISOCode = fromCurrencyISOCode;
	}

	public String getToCurrencyISOCode() {
		return toCurrencyISOCode;
	}

	public void setToCurrencyISOCode(String toCurrencyISOCode) {
		this.toCurrencyISOCode = toCurrencyISOCode;
	}

	public LocalDateTime getDealTimestamp() {
		return dealTimestamp;
	}

	public void setDealTimestamp(LocalDateTime dealTimestamp) {
		this.dealTimestamp = dealTimestamp;
	}

	public BigDecimal getDealAmountInOrderingCurrency() {
		return dealAmountInOrderingCurrency;
	}

	public void setDealAmountInOrderingCurrency(BigDecimal dealAmountInOrderingCurrency) {
		this.dealAmountInOrderingCurrency = dealAmountInOrderingCurrency;
	}
	
	
	
}
