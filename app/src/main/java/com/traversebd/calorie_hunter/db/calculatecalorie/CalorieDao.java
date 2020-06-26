package com.traversebd.calorie_hunter.db.calculatecalorie;

import androidx.room.Dao;
import androidx.room.Insert;
import com.traversebd.calorie_hunter.models.calculatecalorie.Calorie;

@Dao
public interface CalorieDao {
    @Insert
    void insert(Calorie calorie);
}
