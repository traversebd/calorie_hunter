package com.spring.calorieApp.service;

import java.util.List;

import com.spring.calorieApp.model.FoodItem;

public interface FoodItemService {
	FoodItem saveFoodItem(FoodItem foodItem);
	List<FoodItem> getFoodItems();
}
