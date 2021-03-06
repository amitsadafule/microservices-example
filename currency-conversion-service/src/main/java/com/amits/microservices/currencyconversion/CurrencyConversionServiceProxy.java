package com.amits.microservices.currencyconversion;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Amit Sadafule
 *
 * 13-Nov-2018
 */
//@FeignClient(name="currency-exchange-service") instead of sending request directly to exchange service,
//send it throug zuul api gateway
@FeignClient(name="netlix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyConversionServiceProxy {

	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveCurrencyExchange(
			@PathVariable(name="from") String from, 
			@PathVariable(name="to") String to
			);
}
