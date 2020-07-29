package com.spring.calorieApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FoodItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int foodTypeId;
	private String foodTypeTitle;
	private String foodShortDescription;
	private String foodDescription;
	private String title;
	private int icon;
	private double amountOfCalorie;
	private double amountOfFat;
	private double amountOfFiber;
	private double amountOfProtein;
	private double amountOfSodium;
	private double amountOfSugar;
	private double amountOfCarbohydrates;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getFoodTypeId() {
		return foodTypeId;
	}
	public void setFoodTypeId(int foodTypeId) {
		this.foodTypeId = foodTypeId;
	}
	public String getFoodTypeTitle() {
		return foodTypeTitle;
	}
	public void setFoodTypeTitle(String foodTypeTitle) {
		this.foodTypeTitle = foodTypeTitle;
	}
	public String getFoodShortDescription() {
		return foodShortDescription;
	}
	public void setFoodShortDescription(String foodShortDescription) {
		this.foodShortDescription = foodShortDescription;
	}
	public String getFoodDescription() {
		return foodDescription;
	}
	public void setFoodDescription(String foodDescription) {
		this.foodDescription = foodDescription;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getIcon() {
		return icon;
	}
	public void setIcon(int icon) {
		this.icon = icon;
	}
	public double getAmountOfCalorie() {
		return amountOfCalorie;
	}
	public void setAmountOfCalorie(double amountOfCalorie) {
		this.amountOfCalorie = amountOfCalorie;
	}
	public double getAmountOfFat() {
		return amountOfFat;
	}
	public void setAmountOfFat(double amountOfFat) {
		this.amountOfFat = amountOfFat;
	}
	public double getAmountOfFiber() {
		return amountOfFiber;
	}
	public void setAmountOfFiber(double amountOfFiber) {
		this.amountOfFiber = amountOfFiber;
	}
	public double getAmountOfProtein() {
		return amountOfProtein;
	}
	public void setAmountOfProtein(double amountOfProtein) {
		this.amountOfProtein = amountOfProtein;
	}
	public double getAmountOfSodium() {
		return amountOfSodium;
	}
	public void setAmountOfSodium(double amountOfSodium) {
		this.amountOfSodium = amountOfSodium;
	}
	public double getAmountOfSugar() {
		return amountOfSugar;
	}
	public void setAmountOfSugar(double amountOfSugar) {
		this.amountOfSugar = amountOfSugar;
	}
	public double getAmountOfCarbohydrates() {
		return amountOfCarbohydrates;
	}
	public void setAmountOfCarbohydrates(double amountOfCarbohydrates) {
		this.amountOfCarbohydrates = amountOfCarbohydrates;
	}

	

}
