package com.spring.calorieApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MealPlan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String dayOfWeek;
	private int iconRes;
	private String ioodType;
	private String foodItems;

	public MealPlan() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public int getIconRes() {
		return iconRes;
	}

	public void setIconRes(int iconRes) {
		this.iconRes = iconRes;
	}

	public String getIoodType() {
		return ioodType;
	}

	public void setIoodType(String ioodType) {
		this.ioodType = ioodType;
	}

	public String getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(String foodItems) {
		this.foodItems = foodItems;
	}

	
}
