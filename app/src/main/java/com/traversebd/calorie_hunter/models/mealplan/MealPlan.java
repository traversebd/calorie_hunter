package com.traversebd.calorie_hunter.models.mealplan;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MealPlan {
    @PrimaryKey(autoGenerate = true)
    private int Id;
    private String DayOfWeek;
    private int IconRes;
    private String FoodType;
    private String FoodItems;

    public MealPlan() {
    }

    public MealPlan(String dayOfWeek, int iconRes, String foodType, String foodItems) {
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
