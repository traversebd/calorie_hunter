package com.spring.calorieApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.calorieApp.model.FoodItem;
import com.spring.calorieApp.repository.FoodItemRepository;
import com.spring.calorieApp.service.FoodItemService;
@Service
public class FoodItemServiceImpl implements FoodItemService {
	@Autowired
	private FoodItemRepository foodItemRepo;

	@Override
	public FoodItem saveFoodItem(FoodItem foodItem) {
		// TODO Auto-generated method stub
		return foodItemRepo.save(foodItem);
	}

	@Override
	public List<FoodItem> getFoodItems() {
		// TODO Auto-generated method stub
		return foodItemRepo.findAll();
	}

}
