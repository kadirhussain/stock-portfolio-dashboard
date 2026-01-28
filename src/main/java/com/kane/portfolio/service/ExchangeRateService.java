package com.kane.portfolio.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.kane.portfolio.domain.model.Currency;
import com.kane.portfolio.domain.model.ExchangeRate;
import com.kane.portfolio.dto.ExchangeRateDto;

public interface ExchangeRateService {

	public BigDecimal getExchangeRates(Currency currency, LocalDate rateDate);
	
	public ExchangeRate saveHistoricalExchangeRates(ExchangeRateDto dto);
}
