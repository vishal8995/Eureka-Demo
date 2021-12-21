package com.vishal.spring.eureka.client.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ShoppingController {

	@Autowired
	private RestTemplate template;
	
	@GetMapping("/shopping-service/{price}")
	public String invokePaymentService(@PathVariable int price) {
		// String url = "http://localhost:8090/paymentAPI/pay/" + price; // Using this syntax
		// without Eureka will help connecting applications!!
		
		String url = "http://PAYMENT-SERVICE/paymentAPI/pay/" + price;
		
		return template.getForObject(url, String.class);
	}
}
