package com.kane.portfolio.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kane.portfolio.domain.model.Transaction;
import com.kane.portfolio.dto.TransactionDto;
import com.kane.portfolio.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	private final TransactionService transactionService;

	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@PostMapping("/saveTransaction")
	public Transaction saveTransaction(@RequestBody TransactionDto transactionDto) {
		return transactionService.saveTransaction(transactionDto);
	}

	@GetMapping("/getAllTransactions")
	public List<Map<String, Object>> getAllTransactions() {
		return transactionService.getAllTransactions();
	}
}
