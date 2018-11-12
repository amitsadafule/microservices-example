package com.amits.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amits.microservices.limitsservice.beans.LimitConfiguration;

/**
 * @author Amit Sadafule
 *
 *         10-Nov-2018
 */
@RestController
public class LimitsConfigController {

	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfig() {
		return new LimitConfiguration(configuration.getMaximum(),
				configuration.getMinimum());
	}
}
