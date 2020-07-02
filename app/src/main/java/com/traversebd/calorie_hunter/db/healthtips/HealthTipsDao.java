package com.traversebd.calorie_hunter.db.healthtips;

import androidx.room.Dao;
import androidx.room.Insert;
import com.traversebd.calorie_hunter.models.healthtips.HealthTips;

@Dao
public interface HealthTipsDao {
    @Insert
    void insert(HealthTips healthTips);
}
