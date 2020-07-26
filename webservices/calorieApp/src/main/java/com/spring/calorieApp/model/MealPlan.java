package com.spring.calorieApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MealPlan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private String DayOfWeek;
	private int IconRes;
	private String FoodType;
	private String FoodItems;

	public MealPlan() {

	}

	public MealPlan(int id, String dayOfWeek, int iconRes, String foodType, String foodItems) {
		super();
		Id = id;
		DayOfWeek = dayOfWeek;
		IconRes = iconRes;
		FoodType = foodType;
		FoodItems = foodItems;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDayOfWeek() {
		return DayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		DayOfWeek = dayOfWeek;
	}

	public int getIconRes() {
		return IconRes;
	}

	public void setIconRes(int iconRes) {
		IconRes = iconRes;
	}

	public String getFoodType() {
		return FoodType;
	}

	public void setFoodType(String foodType) {
		FoodType = foodType;
	}

	public String getFoodItems() {
		return FoodItems;
	}

	public void setFoodItems(String foodItems) {
		FoodItems = foodItems;
	}

}
