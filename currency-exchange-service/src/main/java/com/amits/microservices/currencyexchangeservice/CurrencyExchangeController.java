package com.amits.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Amit Sadafule
 *
 *         12-Nov-2018
 */
@RestController
public class CurrencyExchangeController {

	@Autowired
	private ExchangeValueRepository repository;
	
	@Autowired
	private Environment environment;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from,
			@PathVariable String to) {
		
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		if (exchangeValue == null) {
			throw new CurrencyExchangeNotFoundException(String.format(
					"Currency Exchange not found for %s to %s", from, to));
		}

		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
	}
}
