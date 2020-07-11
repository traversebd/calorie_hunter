package com.traversebd.calorie_hunter.models.mealplan;

import androidx.lifecycle.LiveData;
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
    private String FoodItems;
    private List<FoodItem> FoodItemList;

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

    public List<FoodItem> getFoodItemList() {
        return FoodItemList;
    }

    public void setFoodItemList(List<FoodItem> foodItemList) {
        FoodItemList = foodItemList;
    }
}
