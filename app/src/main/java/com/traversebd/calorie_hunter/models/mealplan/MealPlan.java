package com.traversebd.calorie_hunter.models.mealplan;

import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.traversebd.calorie_hunter.models.food.FoodItem;
import java.util.List;

@Entity
public class MealPlan {
    @PrimaryKey(autoGenerate = true)
    private int Id;
    private String DayOfWeek;
    private int IconRes;
    private String FoodType;
    private double TotalCalorie;
    private List<FoodItem> FoodItems;

    public MealPlan() {
    }

    public MealPlan(int id, String dayOfWeek, int iconRes, String foodType, double totalCalorie, List<FoodItem> foodItems) {
        Id = id;
        DayOfWeek = dayOfWeek;
        IconRes = iconRes;
        FoodType = foodType;
        TotalCalorie = totalCalorie;
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

    public double getTotalCalorie() {
        return TotalCalorie;
    }

    public void setTotalCalorie(double totalCalorie) {
        TotalCalorie = totalCalorie;
    }

    public List<FoodItem> getFoodItems() {
        return FoodItems;
    }

    public void setFoodItems(List<FoodItem> foodItems) {
        FoodItems = foodItems;
    }
}
