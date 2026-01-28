package com.kane.portfolio.domain.model;

import java.math.BigDecimal;

public class PortfolioPosition {

	private String ticker;
	private int totalShares;
	private BigDecimal netInvestmentUsd = BigDecimal.ZERO;

	public void buy(int quantity, BigDecimal usdAmount) {
		this.totalShares += quantity;
		this.netInvestmentUsd = this.netInvestmentUsd.add(usdAmount);
	}

	public boolean canSell(int quantity) {
		return this.totalShares >= quantity;
	}

	public void sell(int quantity, BigDecimal usdAmount) {
		this.totalShares -= quantity;
		this.netInvestmentUsd = this.netInvestmentUsd.subtract(usdAmount);
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public int getTotalShares() {
		return totalShares;
	}

	public void setTotalShares(int totalShares) {
		this.totalShares = totalShares;
	}

	public BigDecimal getNetInvestmentUsd() {
		return netInvestmentUsd;
	}

	public void setAveragePriceUsd(BigDecimal netInvestmentUsd) {
		this.netInvestmentUsd = netInvestmentUsd;
	}

}
