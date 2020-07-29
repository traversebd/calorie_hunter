package com.spring.calorieApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.calorieApp.model.FoodItem;
import com.spring.calorieApp.service.FoodItemService;

@RestController
@RequestMapping("/foodItem")
public class FoodItemController {

	@Autowired
	private FoodItemService foodItemService;
	@GetMapping
	public List<FoodItem> getFoodItems() {
		return foodItemService.getFoodItems();
	}
	
	
	@PostMapping
	public FoodItem saveFoodItem(@RequestBody FoodItem foodItem) {
		return foodItemService.saveFoodItem(foodItem);
	}
}
