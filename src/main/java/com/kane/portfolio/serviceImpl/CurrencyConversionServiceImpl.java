package com.kane.portfolio.serviceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.kane.portfolio.domain.model.Currency;
import com.kane.portfolio.service.CurrencyConversionService;
import com.kane.portfolio.service.ExchangeRateService;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

	private final ExchangeRateService exchangeRateService;

	public CurrencyConversionServiceImpl(ExchangeRateServiceImpl exchangeRateService) {
		this.exchangeRateService = exchangeRateService;
	}

	@Override
	public BigDecimal convertToUsd(BigDecimal amount, Currency currency, LocalDate date) {
		if (currency == Currency.USD) {
			return amount;
		}

		return amount.multiply(exchangeRateService.getExchangeRates(currency, date));
	}

}
