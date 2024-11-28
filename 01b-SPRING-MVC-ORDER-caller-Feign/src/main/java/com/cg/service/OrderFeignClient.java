package com.cg.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name="1b-SPRING-MVC-PRODUCT", url="${PRODUCT_SERVICE:http://localhost:9091}")
public interface OrderFeignClient {
	@GetMapping("/api/products")
	String getResponse();
}
