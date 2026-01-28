package com.kane.portfolio.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExchangeRateDto {

	private String currency;
	private LocalDate rateDate;
	private BigDecimal usdRate;

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public LocalDate getRateDate() {
		return rateDate;
	}

	public void setRateDate(LocalDate rateDate) {
		this.rateDate = rateDate;
	}

	public BigDecimal getUsdRate() {
		return usdRate;
	}

	public void setUsdRate(BigDecimal usdRate) {
		this.usdRate = usdRate;
	}

}
