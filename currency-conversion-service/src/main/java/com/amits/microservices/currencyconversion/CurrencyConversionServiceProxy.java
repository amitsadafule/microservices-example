package com.amits.microservices.currencyconversion;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Amit Sadafule
 *
 * 13-Nov-2018
 */
@FeignClient(name="currency-exchange-service", url="localhost:8000")
public interface CurrencyConversionServiceProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveCurrencyExchange(
			@PathVariable(name="from") String from, 
			@PathVariable(name="to") String to
			);
}
