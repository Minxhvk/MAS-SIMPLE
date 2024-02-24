package com.example.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

//	@Bean
//	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route(r -> r.path("/first-service/**")
//						.filters(f -> f.rewritePath("/first-service/(?<segment>.*)", "/${segment}"))
//						.uri("http://127.0.0.1:8001"))
//				.route(r -> r.path("/second-service/**")
//						.filters(f -> f.rewritePath("/second-service/(?<segment>.*)", "/${segment}"))
//						.uri("http://127.0.0.1:8002"))
//				.build();
//	}
}
