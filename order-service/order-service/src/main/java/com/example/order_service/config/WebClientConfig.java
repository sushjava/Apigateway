package com.example.order_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientConfig {

	@Bean
	public WebClient.Builder webClientBuilder()
{
		return WebClient.builder();
		
		}
}
