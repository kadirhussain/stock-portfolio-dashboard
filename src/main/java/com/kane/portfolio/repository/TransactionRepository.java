package com.kane.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kane.portfolio.domain.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	
	public List<Transaction> findAllByIsArchivedFalse();
	
	public List<Transaction> findAllByTickerAndIsArchivedFalse(String ticker);

}
