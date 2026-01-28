package com.kane.portfolio.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kane.portfolio.domain.model.Currency;
import com.kane.portfolio.domain.model.Transaction;
import com.kane.portfolio.domain.model.TransactionType;
import com.kane.portfolio.dto.TransactionDto;
import com.kane.portfolio.exception.BusinessException;
import com.kane.portfolio.repository.TransactionRepository;
import com.kane.portfolio.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	private final TransactionRepository transactionRepository;

	public TransactionServiceImpl(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}

	@Override
	public Transaction saveTransaction(TransactionDto dto) {
		Transaction transaction = new Transaction();
		TransactionType transactionType = TransactionType.valueOf(dto.getTransactionType().toUpperCase());
		if (transactionType == TransactionType.SELL) {
			int currentHolding = getCurrentHolding(dto.getTicker());
			if (currentHolding < dto.getQuantity()) {
				throw new BusinessException("You cannot sell " + dto.getQuantity() + " shares of " + dto.getTicker()
						+ " because you only hold " + currentHolding + " shares.");
			}
		}
		if (dto.getQuantity() <= 0) {
			throw new BusinessException("Quantity must be greater than zero");
		}

		if (dto.getLocalPrice() == null || dto.getLocalPrice().compareTo(BigDecimal.ZERO) <= 0) {
			throw new BusinessException("Local price must be greater than zero");
		}

		transaction.setTicker(dto.getTicker());
		transaction.setTradeDate(dto.getTradeDate());
		transaction.setTransactionType(TransactionType.valueOf(dto.getTransactionType().toUpperCase()));
		transaction.setQuantity(dto.getQuantity());
		transaction.setLocalPrice(dto.getLocalPrice());
		transaction.setCurrency(Currency.valueOf(dto.getCurrency().toUpperCase()));

		return transactionRepository.save(transaction);
	}

	public List<Map<String, Object>> getAllTransactions() {
		List<Transaction> transactions = transactionRepository.findAllByIsArchivedFalse();

		if (transactions.isEmpty()) {
			return new ArrayList<>();
		}

		List<Map<String, Object>> response = new ArrayList<>();
		for (Transaction tx : transactions) {
			Map<String, Object> map = new HashMap<>();
			map.put("id", tx.getId());
			map.put("ticker", tx.getTicker());
			map.put("tradeDate", tx.getTradeDate());
			map.put("quantity", tx.getQuantity());
			map.put("localPrice", tx.getLocalPrice());
			map.put("currency", tx.getCurrency());
			response.add(map);

		}

		return response;

	}

	public int getCurrentHolding(String ticker) {
		return transactionRepository.findAllByTickerAndIsArchivedFalse(ticker).stream()
				.mapToInt(tx -> tx.getTransactionType() == TransactionType.BUY ? tx.getQuantity() : -tx.getQuantity())
				.sum();
	}

}
