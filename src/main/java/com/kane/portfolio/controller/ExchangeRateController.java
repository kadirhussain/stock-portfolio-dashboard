package com.kane.portfolio.controller;

import java.math.BigDecimal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kane.portfolio.domain.model.Currency;
import com.kane.portfolio.domain.model.ExchangeRate;
import com.kane.portfolio.dto.ExchangeRateDto;
import com.kane.portfolio.service.ExchangeRateService;

@RestController
public class ExchangeRateController {

	private final ExchangeRateService exchangeRateService;

	public ExchangeRateController(ExchangeRateService exchangeRateService) {
		this.exchangeRateService = exchangeRateService;
	}

	@GetMapping("/getExchangeRate")
	public BigDecimal getExchangeRates(@RequestBody ExchangeRateDto dto) {
		return exchangeRateService.getExchangeRates(Currency.valueOf(dto.getCurrency().toLowerCase()),
				dto.getRateDate());
	}
	
	@PostMapping("/saveExchangeRate")
	public ExchangeRate saveHistoricalExchangeRates(@RequestBody ExchangeRateDto dto) {
		return exchangeRateService.saveHistoricalExchangeRates(dto);
	}

}
