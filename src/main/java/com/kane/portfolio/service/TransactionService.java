package com.kane.portfolio.service;

import java.util.List;
import java.util.Map;

import com.kane.portfolio.domain.model.Transaction;
import com.kane.portfolio.dto.TransactionDto;

public interface TransactionService {

	public Transaction saveTransaction(TransactionDto dto);
	
	public List<Map<String, Object>> getAllTransactions();
}
