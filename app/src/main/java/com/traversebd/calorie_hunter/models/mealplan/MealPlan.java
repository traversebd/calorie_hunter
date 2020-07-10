package com.traversebd.calorie_hunter.models.mealplan;

import androidx.room.Dao;
import androidx.room.PrimaryKey;

@Dao
public class MealPlan {
    @PrimaryKey(autoGenerate = true)
    private int Id;
    private String DayOfWeek;
    private int IconRes;

    public MealPlan() {
    }

    public MealPlan(int id, String dayOfWeek, int iconRes) {
        Id = id;
        DayOfWeek = dayOfWeek;
        IconRes = iconRes;
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
}
