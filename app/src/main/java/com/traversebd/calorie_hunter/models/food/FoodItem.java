package com.traversebd.calorie_hunter.models.food;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class FoodItem {
    @PrimaryKey(autoGenerate = true)
    private int Id;
    private int FoodTypeId;
    private String FoodTypeTitle;
    private String FoodShortDescription;
    private String FoodDescription;
    private String Title;
    private int Icon;
    private double AmountOfCalorie;
    private double AmountOfFat;
    private double AmountOfFiber;
    private double AmountOfProtein;
    private double AmountOfSodium;
    private double AmountOfSugar;
    private double AmountOfCarbohydrates;

    public FoodItem() {
    }

    public FoodItem(int foodTypeId, String foodTypeTitle, String title,String foodShortDescription, String foodDescription, int icon, double amountOfCalorie, double amountOfFat, double amountOfFiber, double amountOfProtein,
                    double amountOfSodium, double amountOfSugar, double amountOfCarbohydrates) {
        FoodTypeId = foodTypeId;
        FoodTypeTitle = foodTypeTitle;
        Title = title;
        FoodShortDescription = foodShortDescription;
        FoodDescription = foodDescription;
        Icon = icon;
        AmountOfCalorie = amountOfCalorie;
        AmountOfFat = amountOfFat;
        AmountOfFiber = amountOfFiber;
        AmountOfProtein = amountOfProtein;
        AmountOfSodium = amountOfSodium;
        AmountOfSugar = amountOfSugar;
        AmountOfCarbohydrates = amountOfCarbohydrates;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getFoodTypeId() {
        return FoodTypeId;
    }

    public void setFoodTypeId(int foodTypeId) {
        FoodTypeId = foodTypeId;
    }

    public String getFoodTypeTitle() {
        return FoodTypeTitle;
    }

    public void setFoodTypeTitle(String foodTypeTitle) {
        FoodTypeTitle = foodTypeTitle;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getIcon() {
        return Icon;
    }

    public void setIcon(int icon) {
        Icon = icon;
    }

    public double getAmountOfCalorie() {
        return AmountOfCalorie;
    }

    public void setAmountOfCalorie(double amountOfCalorie) {
        AmountOfCalorie = amountOfCalorie;
    }

    public double getAmountOfFat() {
        return AmountOfFat;
    }

    public void setAmountOfFat(double amountOfFat) {
        AmountOfFat = amountOfFat;
    }

    public double getAmountOfFiber() {
        return AmountOfFiber;
    }

    public void setAmountOfFiber(double amountOfFiber) {
        AmountOfFiber = amountOfFiber;
    }

    public double getAmountOfProtein() {
        return AmountOfProtein;
    }

    public void setAmountOfProtein(double amountOfProtein) {
        AmountOfProtein = amountOfProtein;
    }

    public double getAmountOfSodium() {
        return AmountOfSodium;
    }

    public void setAmountOfSodium(double amountOfSodium) {
        AmountOfSodium = amountOfSodium;
    }

    public double getAmountOfSugar() {
        return AmountOfSugar;
    }

    public void setAmountOfSugar(double amountOfSugar) {
        AmountOfSugar = amountOfSugar;
    }

    public double getAmountOfCarbohydrates() {
        return AmountOfCarbohydrates;
    }

    public void setAmountOfCarbohydrates(double amountOfCarbohydrates) {
        AmountOfCarbohydrates = amountOfCarbohydrates;
    }

    public String getFoodShortDescription() {
        return FoodShortDescription;
    }

    public void setFoodShortDescription(String foodShortDescription) {
        FoodShortDescription = foodShortDescription;
    }

    public String getFoodDescription() {
        return FoodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        FoodDescription = foodDescription;
    }
}
