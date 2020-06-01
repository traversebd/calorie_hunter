package com.traversebd.calorie_hunter.models.food;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class FoodItem {
    @PrimaryKey(autoGenerate = true)
    private int Id;
    private String Title;
    private int Icon;
    private long AmountOfCalorie;
    private long AmountOfFat;
    private long AmountOfFiber;
    private long AmountOfProtein;
    private long AmountOfSodium;
    private long AmountOfSugar;
    private long AmountOfCarbohydrates;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public long getAmountOfCalorie() {
        return AmountOfCalorie;
    }

    public void setAmountOfCalorie(long amountOfCalorie) {
        AmountOfCalorie = amountOfCalorie;
    }

    public long getAmountOfFat() {
        return AmountOfFat;
    }

    public void setAmountOfFat(long amountOfFat) {
        AmountOfFat = amountOfFat;
    }

    public long getAmountOfFiber() {
        return AmountOfFiber;
    }

    public void setAmountOfFiber(long amountOfFiber) {
        AmountOfFiber = amountOfFiber;
    }

    public long getAmountOfProtein() {
        return AmountOfProtein;
    }

    public void setAmountOfProtein(long amountOfProtein) {
        AmountOfProtein = amountOfProtein;
    }

    public long getAmountOfSodium() {
        return AmountOfSodium;
    }

    public void setAmountOfSodium(long amountOfSodium) {
        AmountOfSodium = amountOfSodium;
    }

    public long getAmountOfSugar() {
        return AmountOfSugar;
    }

    public void setAmountOfSugar(long amountOfSugar) {
        AmountOfSugar = amountOfSugar;
    }

    public long getAmountOfCarbohydrates() {
        return AmountOfCarbohydrates;
    }

    public void setAmountOfCarbohydrates(long amountOfCarbohydrates) {
        AmountOfCarbohydrates = amountOfCarbohydrates;
    }
}
