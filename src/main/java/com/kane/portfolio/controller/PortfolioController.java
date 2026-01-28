package com.kane.portfolio.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kane.portfolio.domain.model.PortfolioPosition;
import com.kane.portfolio.service.PortfolioService;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

	private final PortfolioService portfolioService;

	public PortfolioController(PortfolioService portfolioService) {
		this.portfolioService = portfolioService;
	}

	@GetMapping("/getReport")
	public List<PortfolioPosition> getPortfolioReport() {
		return portfolioService.generateReport();
	}
}
