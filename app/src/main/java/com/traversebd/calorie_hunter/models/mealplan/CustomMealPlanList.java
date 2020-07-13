package com.traversebd.calorie_hunter.models.mealplan;

import com.traversebd.calorie_hunter.models.food.FoodItem;
import java.util.List;

public class CustomMealPlanList {
    private int Id;
    private String DayOfWeek;
    private int IconRes;
    private String FoodType;
    private List<FoodItem> AllFoodItems;

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

    public List<FoodItem> getAllFoodItems() {
        return AllFoodItems;
    }

    public void setAllFoodItems(List<FoodItem> allFoodItems) {
        AllFoodItems = allFoodItems;
    }
}
