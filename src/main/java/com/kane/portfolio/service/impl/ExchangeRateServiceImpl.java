package com.kane.portfolio.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kane.portfolio.domain.model.Currency;
import com.kane.portfolio.domain.model.ExchangeRate;
import com.kane.portfolio.dto.ExchangeRateDto;
import com.kane.portfolio.exception.ExchangeRateNotFoundException;
import com.kane.portfolio.repository.ExchangeRateRepository;
import com.kane.portfolio.service.ExchangeRateService;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

	private final ExchangeRateRepository exchangeRateRepository;

	public ExchangeRateServiceImpl(ExchangeRateRepository exchangeRateRepository) {
		this.exchangeRateRepository = exchangeRateRepository;
	}

	@Override
	public BigDecimal getExchangeRates(Currency currency, LocalDate rateDate) {
		System.out.println("currency :::"+currency);
		System.out.println("rateDate :::"+rateDate);
		return exchangeRateRepository.findByCurrencyAndRateDate(currency, rateDate)
				.orElseThrow(() -> new ExchangeRateNotFoundException(currency, rateDate)).getUsdRate();
	}

	@Override
	public ExchangeRate saveHistoricalExchangeRates(ExchangeRateDto dto) {
		ExchangeRate exchangeRate = new ExchangeRate();

		exchangeRate.setCurrency(Currency.valueOf(dto.getCurrency().toUpperCase()));
		exchangeRate.setRateDate(dto.getRateDate());
		exchangeRate.setUsdRate(dto.getUsdRate());
		return exchangeRateRepository.save(exchangeRate);

	}
}
