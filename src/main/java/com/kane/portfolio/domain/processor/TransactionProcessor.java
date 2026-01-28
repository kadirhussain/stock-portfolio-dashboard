package com.kane.portfolio.domain.processor;

import java.math.BigDecimal;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.kane.portfolio.domain.model.PortfolioPosition;
import com.kane.portfolio.domain.model.Transaction;
import com.kane.portfolio.domain.model.TransactionType;

@Component
public class TransactionProcessor {

	private static final Logger log = LoggerFactory.getLogger(TransactionProcessor.class);

	public void process(Transaction transaction, BigDecimal usdAmount, Map<String, PortfolioPosition> portfolio) {
		PortfolioPosition position = portfolio.computeIfAbsent(transaction.getTicker(), t -> {
			PortfolioPosition p = new PortfolioPosition();
			p.setTicker(t);
			return p;
		});

		if (transaction.getTransactionType() == TransactionType.BUY) {
			position.buy(transaction.getQuantity(), usdAmount);
			return;
		}

		if (!position.canSell(transaction.getQuantity())) {
			log.error("You cannot sell " + transaction.getQuantity() + " shares of "
					+ transaction.getTicker() + " because you only hold " + position.getTotalShares()+" shares");
			return;
		}

		position.sell(transaction.getQuantity(), usdAmount);

	}

}
