package com.kane.portfolio.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.kane.portfolio.domain.model.Currency;

public interface CurrencyConversionService {

	public BigDecimal convertToUsd(BigDecimal amount, Currency currency, LocalDate date);
}
