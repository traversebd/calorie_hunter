package com.traversebd.calorie_hunter.db.healthtips;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.traversebd.calorie_hunter.models.healthtips.HealthTips;
import java.util.List;

@Dao
public interface HealthTipsDao {
    @Insert
    void insert(HealthTips healthTips);

    @Query("select * from HealthTips order by Id desc")
    LiveData<List<HealthTips>> getAllHealthItems();
}

