package com.kane.portfolio.exception;

import java.time.LocalDate;

import com.kane.portfolio.domain.model.Currency;

public class ExchangeRateNotFoundException extends BusinessException {
	
	
	public ExchangeRateNotFoundException(Currency currency, LocalDate date) {
		super("Exchange rate not found for " +currency+" on "+date);
	}
	

}
