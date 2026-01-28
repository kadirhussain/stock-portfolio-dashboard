package com.kane.portfolio.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kane.portfolio.domain.model.Currency;
import com.kane.portfolio.domain.model.ExchangeRate;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

	Optional<ExchangeRate> findByCurrencyAndRateDate(Currency currency, LocalDate rateDate);
}
