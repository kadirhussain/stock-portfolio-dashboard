package com.kane.portfolio.service;

import java.util.List;

import com.kane.portfolio.domain.model.PortfolioPosition;

public interface PortfolioService {

	public List<PortfolioPosition> generateReport();
}
