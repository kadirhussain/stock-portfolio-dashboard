package com.kane.portfolio.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "exchange_rates")
public class ExchangeRate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate rateDate;
	
	@Enumerated(EnumType.STRING)
    private Currency currency;
	
	@Column(precision = 19, scale = 6)
    private BigDecimal usdRate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getRateDate() {
		return rateDate;
	}

	public void setRateDate(LocalDate rateDate) {
		this.rateDate = rateDate;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public BigDecimal getUsdRate() {
		return usdRate;
	}

	public void setUsdRate(BigDecimal usdRate) {
		this.usdRate = usdRate;
	}
	
	
}
