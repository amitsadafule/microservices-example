package com.amits.microservices.currencyconversion;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Amit Sadafule
 *
 *         12-Nov-2018
 */
@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyConversionServiceProxy proxy;
	
	@GetMapping("/currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean retrieveCurrencyConversionBean(
			@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate()
				.getForEntity(
						"http://localhost:8000/currency-exchange/from/{from}/to/{to}",
						CurrencyConversionBean.class, uriVariables);
		CurrencyConversionBean currencyConversion = responseEntity.getBody();

		return new CurrencyConversionBean(currencyConversion.getId(), from, to,
				currencyConversion.getConversionMultiple(), quantity,
				quantity.multiply(currencyConversion.getConversionMultiple()),
				currencyConversion.getPort());
	}
	
	@GetMapping("/currency-convertor-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean retrieveCurrencyConversionBeanFeign(
			@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		CurrencyConversionBean currencyConversion = proxy.retrieveCurrencyExchange(from, to);

		return new CurrencyConversionBean(currencyConversion.getId(), from, to,
				currencyConversion.getConversionMultiple(), quantity,
				quantity.multiply(currencyConversion.getConversionMultiple()),
				currencyConversion.getPort());
	}
}
