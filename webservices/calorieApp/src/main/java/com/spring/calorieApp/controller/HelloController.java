package com.spring.calorieApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.calorieApp.test.HelloWorld;

@RestController
public class HelloController {
	@GetMapping("/hello")
	public HelloWorld hello() {
		return new HelloWorld("Hi calorie app calling from web service");
	}
}
