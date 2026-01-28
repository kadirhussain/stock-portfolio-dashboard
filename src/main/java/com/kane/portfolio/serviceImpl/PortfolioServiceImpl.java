package com.kane.portfolio.serviceImpl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kane.portfolio.domain.model.PortfolioPosition;
import com.kane.portfolio.domain.model.Transaction;
import com.kane.portfolio.domain.processor.TransactionProcessor;
import com.kane.portfolio.repository.TransactionRepository;
import com.kane.portfolio.service.PortfolioService;
import com.kane.portfolio.service.CurrencyConversionService;

@Service
public class PortfolioServiceImpl implements PortfolioService {

	private final TransactionRepository transactionRepository;
	private final TransactionProcessor transactionProcessor;
	private final CurrencyConversionService currencyConversionService;

	public PortfolioServiceImpl(TransactionRepository transactionRepository, TransactionProcessor transactionProcessor,
			CurrencyConversionService currencyConversionService) {
		this.transactionRepository = transactionRepository;
		this.transactionProcessor = transactionProcessor;
		this.currencyConversionService = currencyConversionService;
	}

	@Override
	public List<PortfolioPosition> generateReport() {
		Map<String, PortfolioPosition> portfolio = new HashMap<>();
		List<Transaction> transactions = transactionRepository.findAll();

		for (Transaction tx : transactions) {
			BigDecimal tradeValue = tx.getLocalPrice().multiply(BigDecimal.valueOf(tx.getQuantity()));
			BigDecimal usdAmount = currencyConversionService.convertToUsd(tradeValue, tx.getCurrency(),
					tx.getTradeDate());
			transactionProcessor.process(tx, usdAmount, portfolio);
		}
		return portfolio.values().stream().filter(p -> p.getTotalShares() > 0).toList();

	}

}
