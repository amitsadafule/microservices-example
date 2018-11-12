package com.amits.microservices.currencyexchangeservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Amit Sadafule
 *
 *         12-Nov-2018
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CurrencyExchangeNotFoundException extends RuntimeException {

	/**
	 * @param message
	 */
	public CurrencyExchangeNotFoundException(String message) {
		super(message);
	}

}
