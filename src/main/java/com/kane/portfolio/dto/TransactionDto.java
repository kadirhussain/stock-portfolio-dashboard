package com.kane.portfolio.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionDto {

	private LocalDate tradeDate;

	private String ticker;

	private String transactionType;

	private int quantity;

	private BigDecimal localPrice;

	private String currency;

	public LocalDate getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(LocalDate tradeDate) {
		this.tradeDate = tradeDate;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getLocalPrice() {
		return localPrice;
	}

	public void setLocalPrice(BigDecimal localPrice) {
		this.localPrice = localPrice;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
