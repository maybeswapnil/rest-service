package com.hellochemo.restservice;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@GetMapping("/main")
	public Main doSomething() {
		return new Main(123, "Swapnil");
	}
	
}
