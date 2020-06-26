package com.traversebd.calorie_hunter.db.calculatecalorie;

import androidx.room.Insert;
import com.traversebd.calorie_hunter.models.calculatecalorie.Calorie;

public interface CalorieDao {
    @Insert
    void insert(Calorie calorie);
}
