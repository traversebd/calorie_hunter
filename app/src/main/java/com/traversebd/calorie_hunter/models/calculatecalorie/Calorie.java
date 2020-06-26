package com.traversebd.calorie_hunter.models.calculatecalorie;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Calorie {
    @PrimaryKey(autoGenerate = true)
    private int Id;
    private String Gender;
    private int WeightInKg;
    private int HeightInCm;
    private int Age;
    private int ActivityLevelId;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public int getWeightInKg() {
        return WeightInKg;
    }

    public void setWeightInKg(int weightInKg) {
        WeightInKg = weightInKg;
    }

    public int getHeightInCm() {
        return HeightInCm;
    }

    public void setHeightInCm(int heightInCm) {
        HeightInCm = heightInCm;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getActivityLevelId() {
        return ActivityLevelId;
    }

    public void setActivityLevelId(int activityLevelId) {
        ActivityLevelId = activityLevelId;
    }
}
